var Ego = {};
Ego.General = {
	init: function() {
		
		Ego.Wishlist.init();
		
	},
}
var urlspage = '/yeu-thich';
var urlmain = window.location.href;

Ego.Wishlist = {
	init: function() {
		this.setWishlistProductLoop();
		Ego.Wishlist.wishlistProduct();
	},
	setWishlistProductLoop: function() {
		$('body').on('click', '.remove-wishlist', function(e) {
			Ego.Wishlist.removeWishlist($(this).attr('data-wish'));
		})
		$('body').on('click', '.setWishlist', function(e) {
			//debugger;
			e.preventDefault();
			if ($(this).hasClass('active')) {
				$(this).parent().find('.like-text').text('LÆ°u trong danh sÃ¡ch yÃªu thÃ­ch');
				Ego.Wishlist.removeWishlist($(this).attr('data-wish'));
				var InfoText = 'Báº¡n vá»«a bá» sáº£n pháº©m ra khá»i má»¥c yÃªu thÃ­ch.';
				InfoNoti(InfoText);
			} else {
				var phand = [];
				var handle = $(this).attr('data-wish');
				if (document.cookie.indexOf('ego_wishlist_products') !== -1) {
					var las = Cookies.getJSON('ego_wishlist_products');
					if ($.inArray(handle, las) === -1) {
						phand = [handle];
						for (var i = 0; i < las.length; i++) {
							phand.push(las[i]);
							if (phand.length > 100) {
								break;
							}
						}
						Cookies.set('ego_wishlist_products', phand, {
							expires: 15,
							sameSite: 'None',
							secure: true
						});
					}
				} else {
					phand = [handle];
					Cookies.set('ego_wishlist_products', phand, {
						expires: 15,
						sameSite: 'None',
						secure: true
					});
				}
				$(this).parent().find('.like-text').text('XÃ³a khá»i danh sÃ¡ch yÃªu thÃ­ch');
				Ego.Wishlist.wishlistProduct();
				var SuccessText = "Báº¡n vá»«a thÃªm 1 sáº£n pháº©m vÃ o má»¥c yÃªu thÃ­ch thÃ nh cÃ´ng báº¥m <a style='color:#2196f3' href='/yeu-thich'>vÃ o Ä‘Ã¢y</a> Ä‘á»ƒ tá»›i trang yÃªu thÃ­ch";
				SuccessNoti(SuccessText);
			}
		})
	},
	wishlistProduct: function() {
		if ($('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .sidebar-all-wrap-right-main-list').length > 0) {
			if (document.cookie.indexOf('ego_wishlist_products') !== -1) {
				$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .sidebar-all-wrap-right-main-list').html('')
				var last_wishlist_pro_array = Cookies.getJSON('ego_wishlist_products');
				Ego.Wishlist.activityWishlist();
				var recentview_promises = [];
				for (var i = 0; i < 100; i++) {
					if (typeof last_wishlist_pro_array[i] == 'string') {
						var promise = new Promise(function(resolve, reject) {
							$.ajax({
								url: '/products/' + last_wishlist_pro_array[i] + '?view=wish',
								async: false,
								success: function(product) {
									resolve({
										error: false,
										data: product
									});
								},
								error: function(err) {
									if (err.status === 404) {
										try {
											var u = ((this.url.split('?'))[0]).replace('/products/', '');
											resolve({
												error: true,
												handle: u
											});
										} catch (e) {
											resolve({
												error: false,
												data: ''
											})
										}
									} else {
										resolve({
											error: false,
											data: ''
										});
									}
								}
							})
						});
						recentview_promises.push(promise);

					}
				}
				Promise.all(recentview_promises).then(function(values) {
					if (values.length > 0) {
						$('.headerWishlistCount').removeClass('hidden-count')
						var x = [];
						setTimeout(function() {
							$('.headerWishlistCount').html(values.length)
						}, 500)
						$.each(values, function(i, v) {
							if (v.error) {
								x.push(v.handle);
							} else {
								$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .page-wishlist').append(v.data);
								$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .page-wishlist').show();
								awe_lazyloadImage();
								//theme.init(); // gá»i láº¡i ajax cart
							}
							//console.log(values.length);

						});
						if (x.length > 0) {
							var new_last_viewed_pro_array = [];
							$.each(last_wishlist_pro_array, function(i, v) {
								if ($.inArray(v, x) === -1) {
									new_last_viewed_pro_array.push(v);
								}

							})
							if (new_last_viewed_pro_array.length > 0) {
								Cookies.set('last_viewed_products', new_last_viewed_pro_array, {
									expires: 180,
									sameSite: 'None',
									secure: true
								});
							}
						}
						$('.nothing').addClass('d-none');
						if (urlmain.includes(urlspage)) {
							SwatchGrid();
						}
					} else {
						$('.headerWishlistCount').addClass('hidden-count')
						$('.headerWishlistCount').html('0')
						$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .sidebar-all-wrap-right-main-list').append('<div class="sidebar-all-wrap-right-main-top-error col-12"><span>Danh sÃ¡ch yÃªu thÃ­ch cá»§a báº¡n trá»‘ng <a href="/collections/all">Mua sáº¯m ngay bÃ¢y giá»</a></span></div>')
						$('.nothing').removeClass('d-none');
					}
				});
			} else {
				$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .sidebar-all-wrap-right-main-list').append('<div class="sidebar-all-wrap-right-main-top-error col-12"><span>Danh sÃ¡ch yÃªu thÃ­ch cá»§a báº¡n trá»‘ng <a href="/collections/all">Mua sáº¯m ngay bÃ¢y giá»</a></span></div>')
				jQuery('.nothing').removeClass('d-none');
			}
		} else {
			$('#sidebar-all .sidebar-all-wrap-right[data-type="wishlist"] .sidebar-all-wrap-right-main-list').append('<div class="sidebar-all-wrap-right-main-top-error col-12"><span>Danh sÃ¡ch yÃªu thÃ­ch cá»§a báº¡n trá»‘ng <a href="/collections/all">Mua sáº¯m ngay bÃ¢y giá»</a></span></div>')
			jQuery('.nothing').removeClass('d-none');
		}
	},
	activityWishlist: function() {
		var last_wishlist_pro_array = Cookies.getJSON('ego_wishlist_products');
		$.each(last_wishlist_pro_array, function(i, v) {
			$('.setWishlist[data-wish="' + v + '"]').html('<img src="//bizweb.dktcdn.net/100/438/408/themes/899432/assets/hearted_ico.svg?1678673568653" alt="heart"/>').addClass('active').attr('title', 'Bá» yÃªu thÃ­ch');
			$('.setWishlist[data-wish="' + v + '"]').parent().find('.like-text').html('XÃ³a khá»i danh sÃ¡ch yÃªu thÃ­ch');
		})
	},

	removeWishlist: function(handle) {
		var phand = [];

		$('a[data-wish="' + handle + '"]').html('<img src="//bizweb.dktcdn.net/100/438/408/themes/899432/assets/heart_ico.svg?1678673568653" alt="heart"/>').removeClass('active').attr('title', 'ThÃªm vÃ o yÃªu thÃ­ch');
		if (document.cookie.indexOf('ego_wishlist_products') !== -1) {
			var las = Cookies.getJSON('ego_wishlist_products');
			var flagIndex = $.inArray(handle, las);
			las.splice(flagIndex, 1)
			Cookies.set('ego_wishlist_products', las, {
				expires: 15,
				sameSite: 'None',
				secure: true
			});
		} else {
			phand = [handle];
			Cookies.set('ego_wishlist_products', phand, {
				expires: 15,
				sameSite: 'None',
				secure: true
			});
		}
		Ego.Wishlist.wishlistProduct(3, 5);
	}
}




Ego.Wishlist.init();