window.theme = window.theme || {};
var wW = $(window).width();
var timeout;
var productList = [];
var itemAvailables = [];
var itemNotAvailables = [];
var itemNotVailablesOld = [];
var itemCarts = [];
var confirmPayment = false;
var checkClickBackToCart = false;
const isEventGiftByPriceHappening = true;
let eventProductList = [];
let moneyCounter = 0;
let gift100 = [];
let gift200 = [];
let gift300 = [];
let gift400 = [];
let giftListAll = [];
let selectedGifts = [];
let cartItemList = [];
let isGiftDeleting = false;

function checkGiftVoucer(products){	
	var promise = new Promise(function(resolve, reject){
		jQuery.getJSON('/cart.js', function (data, textStatus) {
			resolve(data);
		});
	})
	promise.then(function(data){
		cart = data;
		Array.prototype.push.apply(products,data.products);
		var productIds = products.map(function(a){
			return a.id
		});
		if($(window).width() > 768){
			$('.wrap-timeline-voucher-desktop').removeClass('d-none');
		}
		else{
			//$('.wrap-timeline-voucher-mobile').removeClass('d-none');
		}

		var totalPrice = 0;
		for(var i = 0;i < cart.items.length;i++){
			var product = cart.items[i];
			if(productIds.includes(product.product_id)) {
				totalPrice += product.line_price;
			}
		}
		
		var total_text = Bizweb.formatMoney(totalPrice,'{{amount_no_decimals_with_comma_separator}}đ');
		
		$('.cart-total-nguyengia').html(total_text)
		var percent = (totalPrice/4800000) * 100;
		if(percent > 100){
			percent = 100;
		}
		$('.timeline-voucher .line .detail .percent').css('width',percent+'%');
		if(totalPrice >= 1200000) {
			$(".timeline-voucher .line .detail").addClass("active");

			$('.timeline-voucher .line .detail .line-1').removeClass("active");
			$('.timeline-voucher .line .detail .line-2').removeClass("active");
			$('.timeline-voucher .line .detail .line-3').removeClass("active");
			$('.timeline-voucher .line .detail .line-4').removeClass("active");
			if(totalPrice > 1200000 && totalPrice < 2400000){
				$('.timeline-voucher .receive .detail .number-1').addClass("active");

				$('.timeline-voucher .line .detail .line-1').addClass("active");

				$('.timeline-voucher .buy .detail .number-1').addClass("active");
			}
			else if(totalPrice >= 2400000 && totalPrice < 3600000){
				$('.timeline-voucher .receive .detail .number-1').addClass("active");
				$('.timeline-voucher .receive .detail .number-2').addClass("active");

				$('.timeline-voucher .line .detail .line-1').addClass("active");
				$('.timeline-voucher .line .detail .line-2').addClass("active");

				$('.timeline-voucher .buy .detail .number-1').addClass("active");
				$('.timeline-voucher .buy .detail .number-2').addClass("active");
			}
			else if(totalPrice >= 3600000 && totalPrice < 4800000){
				$('.timeline-voucher .receive .detail .number-1').addClass("active");
				$('.timeline-voucher .receive .detail .number-2').addClass("active");
				$('.timeline-voucher .receive .detail .number-3').addClass("active");

				$('.timeline-voucher .line .detail .line-1').addClass("active");
				$('.timeline-voucher .line .detail .line-2').addClass("active");
				$('.timeline-voucher .line .detail .line-3').addClass("active");

				$('.timeline-voucher .buy .detail .number-1').addClass("active");
				$('.timeline-voucher .buy .detail .number-2').addClass("active");
				$('.timeline-voucher .buy .detail .number-3').addClass("active");
			}
			else if(totalPrice >= 4800000){
				$('.timeline-voucher .receive .detail .number-1').addClass("active");
				$('.timeline-voucher .receive .detail .number-2').addClass("active");
				$('.timeline-voucher .receive .detail .number-3').addClass("active");
				$('.timeline-voucher .receive .detail .number-4').addClass("active");

				$('.timeline-voucher .line .detail .line-1').addClass("active");
				$('.timeline-voucher .line .detail .line-2').addClass("active");
				$('.timeline-voucher .line .detail .line-3').addClass("active");
				$('.timeline-voucher .line .detail .line-4').addClass("active");

				$('.timeline-voucher .buy .detail .number-1').addClass("active");
				$('.timeline-voucher .buy .detail .number-2').addClass("active");
				$('.timeline-voucher .buy .detail .number-3').addClass("active");
				$('.timeline-voucher .buy .detail .number-4').addClass("active");
			}
		}
		else {
			var priceAdd = 1200000-
			$(".timeline-voucher .line .detail").removeClass("active");
		}
	})
}
function handleLineItemCart(callbackVoucher){
	if(productList.length > 0){
		callbackVoucher(productList);
		return;
	}
	var products = [];
	var cart = {};
	var promise = new Promise(function(resolve, reject){
		jQuery.getJSON('/cart.js', function (data, textStatus) {
			resolve(data);
		});
	})
	promise.then(function(data){
		cart = data;
		return new Promise(function(resolve, reject){
			jQuery.getJSON('/collections/nguyen-gia/products.json?page=1&limit=1000', function (data) {
				resolve(data);

			});
		})
	}).then(function(data){
		Array.prototype.push.apply(products,data.products);
		return new Promise(function(resolve, reject){
			jQuery.getJSON('/collections/nguyen-gia/products.json?page=2&limit=250', function (data) {
				resolve(data);
			});
		})
	}).then(function(data){
		Array.prototype.push.apply(products,data.products);
		productList = products;
		callbackVoucher(products);
		
	})
}
//handleLineItemCart();
function handleInfoVoucher(products){
	var textNoti = "";
	var totalPrice = 0;
	var priceAdd = "";
	var productIds = products.map(function(a){
			return a.id
	});
	var promise = new Promise(function(resolve, reject){
		jQuery.getJSON('/cart.js', function (data, textStatus) {
			resolve(data);
		});
	})
	promise.then(function(data){
		cart = data;
		for(var i = 0;i < cart.items.length;i++){
			var product = cart.items[i];
			if(productIds.includes(product.product_id)) {
				totalPrice += product.line_price;
			}	
		}
		if(totalPrice < 1200000){
			priceAdd = (1200000 - totalPrice)/1000 + "K";
			if ($(window).width() > 768) {
				textNoti = `<div class="line-1">Bạn được Freeship.</div> <div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD200K</div>`;
			}
			else {
				textNoti = `<div class="line-1">Bạn được Freeship.</div> <div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD200K</div>`;
			}
		}
		else if(totalPrice >= 1200000 && totalPrice < 2400000){
			priceAdd = (2400000 - totalPrice)/1000 + "K";
			if ($(window).width() > 768) {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD200K. <div class="copy-voucher" onclick="copyVoucherr('YD200K')">Sao chép mã</div></div> <div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD400K</div>`;
			}
			else {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD200K. <div class="copy-voucher" onclick="copyVoucherr('YD200K')"></div> </div><div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD400K</div>`;
			}
			
		}
		else if(totalPrice >= 2400000 && totalPrice < 3600000){
			priceAdd = (3600000 - totalPrice)/1000 + "K";
			if ($(window).width() > 768) {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD400K. <div class="copy-voucher" onclick="copyVoucherr('YD400K')">Sao chép mã</div></div> <div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD600K</div>`;
			}
			else {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD400K. <div class="copy-voucher" onclick="copyVoucherr('YD400K')"></div></div> <div class="line-2">Mua thêm ${priceAdd} để sử dụng voucher YD600K</div>`;
			}
			
		}
		else if(totalPrice >= 3600000 && totalPrice < 4800000){
			priceAdd = (4800000 - totalPrice)/1000 + "K";
			if ($(window).width() > 768) {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD600K <div class="copy-voucher" onclick="copyVoucherr('YD600K')">Sao chép mã</div></div><div>Mua thêm ${priceAdd} để sử dụng voucher YD800K</div>`;
			}
			else {
				textNoti = `<div class="line-1">Bạn được Freeship và voucher YD600K <div class="copy-voucher" onclick="copyVoucherr('YD600K')"></div></div><div>Mua thêm ${priceAdd} để sử dụng voucher YD800K</div></div>`;
			}
			
		}
		else {
			if ($(window).width() > 768) {
				textNoti = `<div class="line-1">Bạn được Freeship và được sử dụng voucher YD800K. </div><div class="copy-voucher" onclick="copyVoucherr('YD800K')">Sao chép mã</div>`;
			}
			else {
				textNoti = `<div class="line-1 line-1-800k">Bạn được Freeship và được sử dụng voucher YD800K. <div class="copy-voucher" onclick="copyVoucherr('YD800K')"></div></div>`;
			}
			
		}
		$(".info-voucher").html(textNoti);
	})

}

function copyVoucherr(value){
	navigator.clipboard.writeText(value);
	$(".header-nguyengia").addClass("active");
	$(".noti-copy").css({'opacity':'1'});
	$(".wrap-noti-copy-success-mobile").addClass("show");
	setTimeout(function(){
		$(".noti-copy").css({'opacity':'0'});
		$(".wrap-noti-copy-success-mobile").removeClass("show");
	},3000)
}

function check_number_free_delivery () {
	var total = parseInt($('.cart-drop').attr('data-total'));
	var percent = (total/498000)*100;
	if (percent >= 100) {
		percent = 100;
		$('.timeline-free-delivery .line .line-detail').addClass('active');
	}
	else{
		$('.timeline-free-delivery .line .line-detail').removeClass('active');
	}
	setTimeout(function(){
		$('.timeline-free-delivery .line .detail .percent').css('width',percent+'%')
	},500);
}

function check_number_gift_mb () {
	var total = parseInt(parseInt($('.cart-drop').attr('data-total'))/498000);
	
	var total_next = Bizweb.formatMoney((total + 1)*498000 - parseInt($('.main-cart-page .total-price').text().replace(/\.|đ/g,'')), "{{amount_no_decimals_with_comma_separator}}đ");  
	
	$('.result .number').text(total);
	var number3 = parseInt($('.receive .number-3').text());
	$('.timeline-gift .buy-ex b').text(total_next);
	$('.timeline-gift .buy-ex .next-gift').text((total + 1)*498+'k');
	if (total >=1 ) {
		$('.timeline-gift .line').addClass('active');
	} else {
		$('.timeline-gift .line').removeClass('active');
	}
	if (total > 2) {
		$('.buy .number-3').text((total+1)*498+'k');
		$('.buy .number-2').text(total*498+'k');
		$('.buy .number-1').text((total - 1)*498+'k');
		
		$('.line .line-3').attr('data-number',total + 1);
		$('.line .line-2').attr('data-number',total);
		$('.line .line-1').attr('data-number',total - 1);
		
		$('.receive .number-3').text(total + 1);
		$('.receive .number-2').text(total);
		$('.receive .number-1').text(total - 1);
		var percent = ((parseInt($('.cart-drop').attr('data-total')) - (total - 1)*498000)/996000)*100;
	} else {
		$('.buy .number-3').text(3*498+'k');
		$('.buy .number-2').text(2*498+'k');
		$('.buy .number-1').text(1*498+'k');
		
		$('.line .line-3').attr('data-number',3);
		$('.line .line-2').attr('data-number',2);
		$('.line .line-1').attr('data-number',1);
		
		$('.receive .number-3').text(3);
		$('.receive .number-2').text(2);
		$('.receive .number-1').text(1);
		
		var percent = ((parseInt($('.cart-drop').attr('data-total')) - 498000)/996000)*100;
	}
	
	setTimeout(function(){
		$('.line .line-detail').removeClass('active');
		$('.line .line-detail[data-number="'+(total - 1)+'"]').addClass('active');
		$('.line .line-detail[data-number="'+total+'"]').addClass('active');
		$('.line .detail .percent').css('width',percent+'%')
	},500);
}
function check_number_gift () {
	var number_gift = 0;
	var total = parseInt(parseInt($('.main-cart-page .total-price').text().replace(/\.|đ/g,''))/498000);
	$('.cart-item.gift').each(function() {
		var number = parseInt($(this).find('.number-sidebar').val());
		number_gift = number_gift + number;
	});
	if(number_gift > total ) {									
		alert('Giá trị đơn hàng không đủ nhận quà, vui lòng xóa bớt quà tặng!');
	} else {
		window.location.href='/checkout'
	}
}

function check_inventory(step) {
	if(!confirmPayment) {
		var promises = [];
		var productIds = [];
		var items = itemCarts;
		for(var i = 0; i < itemCarts.length; i++) {
			if(!productIds.includes(items[i].id)) {
				promises.push(getProductInfo(items[i].url));
				productIds.push(items[i].id);
			}

		}
		itemAvailables = [];
		itemNotAvailables = [];
		Promise.all(promises).then((results) => {		
			for(var i = 0; i < items.length; i++) {
				for(var j = 0; j < results.length; j++){
					if(items[i].id == results[j].id){
						for(var k = 0; k < results[j].variants.length; k++){
							if(results[j].variants[k].id == items[i].variantId){
								if(results[j].variants[k].available && results[j].variants[k].inventory_quantity >= items[i].itemQty) {
									itemAvailables.push(items[i]);
								}
								else {
									itemNotAvailables.push(items[i]);
								}
							}
						}
					}
				}				
			}
			if(itemNotAvailables.length > 0){
				if(step == 1) {
					$(".wrap-popup-confirm-payment").css('visibility','visible');
					$('.popup-confirm-payment').css('visibility','visible');
					itemNotVailablesOld = itemNotAvailables;
				}
				else {
					if(JSON.stringify(itemNotAvailables) !== JSON.stringify(itemNotVailablesOld)) {
						$(".popup-confirm-payment .content").html("Có thêm sản phẩm hết hàng mới được cập nhật. Bạn có muốn tiếp tục thanh toán không?");
						itemNotVailablesOld = itemNotAvailables;
					}
					else {
						for(var i =0; i < itemNotAvailables.length; i++) {
							var params = {
								type: 'POST',
								url: '/cart/change.js',
								data: 'quantity=' + 0 + '&line=' + itemNotAvailables[i].line,
								dataType: 'json',
								success: function(cart) {
								}
							};
							jQuery.ajax(params);
						}
						setTimeout(() => {
							window.location.href='/checkout';  
						},1000)
					}
				}
			}
			else {
				window.location.href='/checkout';
			}
		}).catch((e) => { 
			console.log(e);
		})
	}
	else {
		for(var i =0; i < itemNotAvailables.length; i++) {
			var params = {
				type: 'POST',
				url: '/cart/change.js',
				data: 'quantity=' + 0 + '&line=' + itemNotAvailables[i].line,
				dataType: 'json',
				success: function(cart) {
				}
			};
			jQuery.ajax(params);
		}
		setTimeout(() => {
			window.location.href='/checkout';  
		},1000)
	}
	
}
function getProductInfo(url) {
	return new  Promise(function(resolve, reject){
		jQuery.getJSON(url+'.json', function (data, textStatus) {
				resolve(data);
		})
	})				
}

$(document).on('click','.backdrop__body-backdrop___1rvky.active, .cart_btn-close', function() {   
	$('.backdrop__body-backdrop___1rvky, .cart-sidebar, #popup-cart-desktop, .popup-cart-mobile').removeClass('active');
	$('.CartSideContainer').html('');
	return false;
})

function getPromise(url) {
	return new  Promise(function(resolve, reject){
		jQuery.get(url, function (data, textStatus) {
				resolve(data);
		})
	})				
}


function getContentGift(url, selector) {
	url = url+"?view=gift";
	$.ajax({
		type: 'GET',
		url: url,
		dataType: "html",
		beforeSend: function() {
			$(selector).html('');
		},
		success: function(data) {
			var content = $(data);
			setTimeout(function(){
				$(selector).html(content.html());
				awe_lazyloadImage();
			},500);
			var cart_rows = $('.cart-item.gift');
		}
	});
}

Bizweb.addItemFromForm = function(form, callback, errorCallback) {
	$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift-2').addClass("d-none");	
	$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift-2').addClass("d-none");
	var params = {
		type: 'POST',
		url: '/cart/add.js',
		data: jQuery(form).serialize(),
		dataType: 'json',
		success: function(line_item) {
			$(".count-product").text(line_item.quantity);
			$(".count-product").addClass("active");
			if ((typeof callback) === 'function') {
				callback(line_item, form);
				if (wW > 1200) {
					$('#popup-cart-desktops').addClass('active');
					//$('.cart-drop').addClass('active');
					setTimeout(function(){
						$('.cart-drop').removeClass('active');
					}, 3000);
					$(".wrap-noti-add-to-cart-product-popup-desktop .product-info-right .product-name").html(line_item.title);
					$(".wrap-noti-add-to-cart-product-popup-desktop .product-info-left .image").html(`<img src="${line_item.image}" />`);
					$('.wrap-noti-add-to-cart-product-popup-desktop .color-size').text(line_item.variant_title);
					
					$(".noti-content-product-popup .price").html(Bizweb.formatMoney( line_item.price,'{{amount_no_decimals_with_comma_separator}}đ'));
					
					if(conditionPromotionJean) {
						$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift').removeClass("d-none");	
						$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift .noti-gift-quantity').text(`0${jQuery(form).find("#qty").val()}`);
					}
					$(".wrap-noti-add-to-cart-product-popup-desktop").addClass('show');
					setTimeout(function() {
						$(".wrap-noti-add-to-cart-product-popup-desktop").removeClass('show');
					},5000)

				}else {
					AddCartMobile(line_item);
					$(".wrap-noti-add-to-cart-product-popup-mobile .product-info-right .product-name").html(line_item.title);
					$(".wrap-noti-add-to-cart-product-popup-mobile .product-info-left .image").html(`<img src="${line_item.image}" />`);
					$('.wrap-noti-add-to-cart-product-popup-mobile .color-size').text(line_item.variant_title);
					
					$(".noti-content-product-popup .price").html(Bizweb.formatMoney( line_item.price,'{{amount_no_decimals_with_comma_separator}}đ'));
					
					if(conditionPromotionJean) {
						$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift').removeClass("d-none");	
						$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift .noti-gift-quantity').text(`0${jQuery(form).find("#qty").val()}`);
					}
					$(".wrap-noti-add-to-cart-product-popup-mobile").addClass('show');
					setTimeout(function() {
						$(".wrap-noti-add-to-cart-product-popup-mobile").removeClass('show');
					},5000)
				}
			}
		},
		error: function(XMLHttpRequest, textStatus) {
			if ((typeof errorCallback) === 'function') {
				errorCallback(XMLHttpRequest, textStatus);
			}
			else {
				Bizweb.onError(XMLHttpRequest, textStatus);
			}
		}
	};
	jQuery.ajax(params);
};
	
/*========================
Popup cart mobile
=========================*/


/*============================================================================
  Override POST to cart/change.js. Returns cart JSON.
    - Use product's line in the cart instead of ID so custom
      product properties are supported.
==============================================================================*/
Bizweb.changeItem = function(line, quantity, callback) {
	var params = {
		type: 'POST',
		url: '/cart/change.js',
		data: 'quantity=' + quantity + '&line=' + line,
		dataType: 'json',
		success: function(cart) {
			if ((typeof callback) === 'function') {
				callback(cart);
			}
			else {
				Bizweb.onCartUpdate(cart);
			}
		},
		error: function(XMLHttpRequest, textStatus) {
			Bizweb.onError(XMLHttpRequest, textStatus);
		}
	};
	jQuery.ajax(params);
};
function getChangeItemPromise(line, quantity) {
	return new Promise(function(resolve, reject) {
		var params = {
			type: 'POST',
			url: '/cart/change.js',
			data: 'quantity=' + quantity + '&line=' + line,
			dataType: 'json',
			success: function(cart) {
				resolve(cart)
			},
			error: function(XMLHttpRequest, textStatus) {
				Bizweb.onError(XMLHttpRequest, textStatus);
				reject(textStatus);
			}
		};
		jQuery.ajax(params);
	});
}
function getChangeItemPromiseByVariantId(variantId, quantity) {
	return new Promise(function(resolve, reject) {
		var params = {
			type: 'POST',
			url: '/cart/change.js',
			data: 'quantity=' + quantity + '&VariantId=' + variantId,
			dataType: 'json',
			success: function(cart) {
				resolve(cart)
			},
			error: function(XMLHttpRequest, textStatus) {
				Bizweb.onError(XMLHttpRequest, textStatus);
				reject(textStatus);
			}
		};
		jQuery.ajax(params);
	});
}

/*============================================================================
  GET cart.js returns the cart in JSON.
==============================================================================*/
Bizweb.getCart = function(callback) {
	jQuery.getJSON(`/cart.js?v1=${new Date()}`, function (cart, textStatus) {
		if ((typeof callback) === 'function') {
			callback(cart);
		}
		else {
			Bizweb.onCartUpdate(cart);
		}
	});
};
/*============================================================================
  Ajax Bizweb Add To Cart
==============================================================================*/
var ajaxCart = (function(module, $) {
	'use strict';

	// Public functions
	var init, loadCart;

	// Private general variables
	var settings, isUpdating, $body;

	// Private plugin variables
	var $formContainer, $errorsContainer, $addToCart, $cartCountSelector, $nameItemAdd, $cartCostSelector, $cartContainer, $cartContainerMobile, $cartContainerPage, $cartPopup, $cartContainerHeader, $cartContainerSidebar, $countItem;

	// Private functions
	var updateCountPrice, formOverride, itemAddedCallback, itemAddedNoti, itemErrorCallback, cartUpdateCallback, buildCart, cartCallback, adjustCart, adjustCartCallback, qtySelectors, validateQty;

	/*============================================================================
    Initialise the plugin and define global options
  ==============================================================================*/
	init = function (options) {

		// Default settings
		settings = {
			formSelector       		: '[data-cart-form]',
			errorSelector      		: '.product-single__errors',
			cartContainer      		: '.CartSideContainer, .CartPageContainer, .CartHeaderContainer, .cartPopupContainer, .CartMobileContainer',
			cartContainerPage  		: '.CartPageContainer',
			cartContainerSidebar  	: '.CartSideContainer',
			cartContainerMobile  	: '.CartMobileContainer',
			cartContainerHeader  	: '.CartHeaderContainer',
			cartContainerPopup  	: '.cartPopupContainer',
			addToCartSelector  		: '.add_to_cart',
			countItem			 	: '.count_item_pr',
			cartCountSelector  		: '.count_item_pr',
			nameItemAdd  			: '.cart-popup-name',
			cartCostSelector   		: null,
			moneyFormat        		: '$',
			disableAjaxCart    		: false,
			enableQtySelectors 		: true
		};

		// Override defaults with arguments
		$.extend(settings, options);

		// Select DOM elements
		$formContainer     		= $(settings.formSelector);
		$errorsContainer   		= $(settings.errorSelector);
		$cartContainer     		= $(settings.cartContainer);
		$cartContainerPage 		= $(settings.cartContainerPage);
		$cartContainerSidebar 	= $(settings.cartContainerSidebar);
		$cartContainerMobile 	= $(settings.cartContainerMobile);
		$cartContainerHeader 	= $(settings.cartContainerHeader);
		$cartPopup				= $(settings.cartContainerPopup);
		$addToCart         		= $formContainer.find(settings.addToCartSelector);
		$nameItemAdd 			= $(settings.nameItemAdd);
		$cartCountSelector 		= $(settings.cartCountSelector);
		$cartCostSelector  		= $(settings.cartCostSelector);
		$countItem 		   		= $(settings.countItem);

		// General Selectors
		$body = $('body');

		// Track cart activity status
		isUpdating = false;

		// Setup ajax quantity selectors on the any template if enableQtySelectors is true
		if (settings.enableQtySelectors) {
			qtySelectors();
		}

		// Take over the add to cart form submit action if ajax enabled
		if (!settings.disableAjaxCart && $addToCart.length) {
			formOverride();
		}

		// Run this function in case we're using the quantity selector outside of the cart
		adjustCart();
	};

	loadCart = function () {
		Bizweb.getCart(cartUpdateCallback);
	};

	updateCountPrice = function (cart) {
		if ($cartCountSelector) {
			$cartCountSelector.html(cart.item_count).removeClass('hidden-count');
			if (cart.item_count === 0) {
				$cartCountSelector.addClass('hidden-count');
			}
		}
		if ($cartCostSelector) {
			$cartCostSelector.html(Bizweb.formatMoney(cart.total_price, theme.settings.moneyFormat));
		}
	};

	function formarCurrencyVND(money) {
		return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND', currencyDisplay: "code" }).format(money).replace("VND", "").trim()
	}

	function clearGift() {
		const promises = [];
		selectedGifts.sort((a, b) => b.line - a.line);
		selectedGifts.forEach(item => {
			promises.push(getChangeItemPromiseByVariantId(item.variantId, 0));
		});
		Promise.all(promises).then((carts)=> {
			selectedGifts = [];
			setTimeout(function() {
				Bizweb.getCart(cartUpdateCallback);
				isGiftDeleting = false;
			}, 200);
		});
	}
	
	function getBuymoreNotification() {
		const buymoreNoti = $("#buymore_notification");
		if (moneyCounter <= 0) {
			buymoreNoti.addClass("d-none");
		}
		if (buymoreNoti.hasClass("d-none") && moneyCounter > 0) {
			buymoreNoti.removeClass("d-none");
		}

		let moneyToGetGift = 0;
		
		if (moneyCounter < 1996000) {
			moneyToGetGift = 1996000 - moneyCounter;
		}
		if (moneyCounter < 1497000) {
			moneyToGetGift = 1497000 - moneyCounter;
		} 
		if(moneyCounter < 998000) {
			moneyToGetGift = 998000 - moneyCounter;
		}
		if (moneyCounter < 499000) {
			moneyToGetGift = 499000 - moneyCounter;
		}
		
		if (moneyToGetGift <= 0) {
			buymoreNoti.addClass("d-none");
		}
		buymoreNoti.html(`
			<div>
				<div class="message-normal">Mua thêm ${formarCurrencyVND(moneyToGetGift)}đ để nhận thêm quà tặng</div>
				<div class="message-note">* CTKM chỉ áp dụng với các sản phẩm có trong danh sách sản phẩm nguyên giá</div>
			</div>
			<div>
				<a href="/dai-tiec-tri-an" class="message-link">
					<span>Xem danh sách sản phẩm</span>
					<span class="arrow"></span>
				</a>
			</div>
		`);
	}
	
	function handleCartPopupNoti(oldGiftList, totalGiftMoney, oldCartItemList) {
		
		const oldQuantity = oldCartItemList.reduce((accumulator, item) => accumulator + item.itemQty, 0);
		const newQuantity = cartItemList.reduce((accumulator, item) => accumulator + item.itemQty, 0);
		
		if (oldQuantity < newQuantity) {
			let message = "";
			let itemTemp = undefined;
			
			let moneyToGetGift = 0;
			if (moneyCounter < 499000) {
				moneyToGetGift = 499000 - moneyCounter;
			}					
			
			for(let i = 0; i < cartItemList.length; i += 1) {
				const oldItem = oldCartItemList.find(oldItem => oldItem.id === cartItemList[i].id);
				if(oldItem) {
					if (oldItem.itemQty < cartItemList[i].itemQty) {
						itemTemp = cartItemList[i];
						break;
					}
				} else {
					itemTemp = cartItemList[i];
					break;
				}
			}
			
			if (moneyCounter < 499000) {
				message = `Mua thêm ${formarCurrencyVND(moneyToGetGift)}đ để nhận quà`;
			} else {
				message = `Bạn nhận phần quà ${formarCurrencyVND(totalGiftMoney)}đ`;
			}

			if (itemTemp && eventProductList.some(prodItem => prodItem.variants.some(variantItem => variantItem.id === itemTemp.variantId)) && message !== "") {
				if (wW > 1200) {
					$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift').addClass("d-none");
					$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift-2').removeClass("d-none");
					$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift-2 .noti-gift-2-message').text(message);
				} else {
					$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift').addClass("d-none");
					$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift-2').removeClass("d-none");
					$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift-2 .noti-gift-2-message').text(message);
				}	
			}
		} else {
			$('.wrap-noti-add-to-cart-product-popup-desktop .noti-gift-2').addClass("d-none");
			$('.wrap-noti-add-to-cart-product-popup-mobile .noti-gift-2').addClass("d-none");
		}
	}
	
	function renderGifts(cart) {
		if(eventProductList.length > 0) {
			giftListAll = [];
			const moneyTemp = moneyCounter;
			moneyCounter = 0;
			const oldGiftList = giftListAll;
			const cartTemp = cart;
			const giftList= [];
			selectedGifts = [];
			let totalGiftMoney = 0;
			let availableGiftMoney = 0;
			const oldCartItemList = [...cartItemList];
			cartItemList = cart.items;
			cartTemp.items.forEach((item) => {
				if(eventProductList.some(prodItem => prodItem.variants.some(variantItem => variantItem.id === item.variantId))) {
					moneyCounter += item.itemQty * item.pricePrimitive;
				}
				if (item.gift === "gift-by-price") {
					selectedGifts.push(item);
				}
			});
			
			if (moneyTemp > moneyCounter) {
				clearGift();
			}
			if (moneyCounter >= 499000) {
				giftListAll = [...giftListAll, ...gift100];
				totalGiftMoney = 100000;
			} 
			if (moneyCounter >= 998000) {
				giftListAll = [...giftListAll, ...gift200];
				totalGiftMoney = 200000;
			}
			if (moneyCounter >= 1497000) {
				giftListAll = [...giftListAll, ...gift300];
				totalGiftMoney = 300000;
			}
			if (moneyCounter >= 1996000) {
				giftListAll = [...giftListAll, ...gift400];
				totalGiftMoney = 400000;
			}
			
			selectedGifts.forEach(item => {
				const giftItem = giftListAll.find(itemAll => itemAll.id === item.id);
				if (giftItem) {
					availableGiftMoney -= giftItem.giftPrice * item.itemQty;
				}
			});
			
			availableGiftMoney += totalGiftMoney;
			
			//getBuymoreNotification();
			//handleCartPopupNoti(oldGiftList, totalGiftMoney, oldCartItemList);
			
			if(giftListAll.length > 0 && availableGiftMoney > 0) {
				$(".CartGiftContainer").removeClass("d-none");
			} else {
				$(".CartGiftContainer").addClass("d-none");
			}
			
			// render message
			const giftMessage = $("#gift-list-message");
			if (availableGiftMoney === totalGiftMoney) {
				giftMessage.html(`
					<b>Tổng giá trị gói quà tặng của bạn là ${
						formarCurrencyVND(totalGiftMoney)
					}đ.</b>
				`);
			} else {
				giftMessage.html(`
					<b>Tổng giá trị gói quà tặng của bạn là ${
						formarCurrencyVND(totalGiftMoney)
					}đ. Giá trị quà tặng còn lại là ${
						formarCurrencyVND(availableGiftMoney)
					}đ</b>
				`);
			}
			
			// render gift list
			const eventGiftList = $("#eventGiftList");
			eventGiftList.html("");
			giftListAll.forEach((item, index) => {
				const disabled = item.giftPrice > availableGiftMoney;
				const qualityCanBuy = Math.floor(availableGiftMoney / item.giftPrice);
				const minusFunc = `onclick="(function(e){ const inputDoc = $(e.target).siblings('input'); if(inputDoc.val() < 3) { $('#items-count2-minus-${index}').prop('disabled', true); } if(inputDoc.val() > 1) { inputDoc.val(inputDoc.val() - 1); $('#items-count2-plus-${index}').prop('disabled', false); };return false;})(arguments[0]); return false;"`;
				const plusFunc = `onclick="(function(e){ const inputDoc = $(e.target).siblings('input'); if(inputDoc.val() == ${qualityCanBuy - 1}) { $('#items-count2-plus-${index}').prop('disabled', true); } if (inputDoc.val() < ${qualityCanBuy}) { inputDoc.val(parseInt(inputDoc.val()) + 1); $('#items-count2-minus-${index}').prop('disabled', false); } return false;})(arguments[0]); return false;"`;
				eventGiftList.append(`
					<div class="item-row item-gift d-flex">
						<img src="${item.featured_image}" width="90" height="120" class="item_thumbnail" alt="gift 01" />
						<div class="grid_cart_info d-flex">
							<div class="info_name">
								<div>${item.name}</div>
								<div class="info_checkavailable">Chọn tối đa ${qualityCanBuy} sản phẩm</div>
							</div>
							<div class="info_price">
								<div class="new_price">${formarCurrencyVND(0)}đ</div>
								<div class="removed old_price">${formarCurrencyVND(item.giftPrice)}đ</div>
							</div>
							<div class="info_quantity d-flex justify-content-md-center align-items-center align-items-md-start">
								<div class="ajaxcart__qty input-group-btn">
									<button type="button" id="items-count2-minus-${index}" disabled class="ajaxcart__qty-adjust ajaxcart__qty--minus items-count2" ${minusFunc} >
										-
									</button>
									<input type="text" name="updates[]" readonly ${disabled ? "disabled" : ""} class="ajaxcart__qty-num number-sidebar input-count-gift" maxlength="3" value="1" min="0" aria-label="quantity" pattern="[0-9]*">
									<button type="button" id="items-count2-plus-${index}" ${qualityCanBuy === 1 || disabled ? "disabled" : ""} class="ajaxcart__qty-adjust ajaxcart__qty--plus items-count2" ${plusFunc} >
										+				
									</button>
								</div>
							</div>
							<div class="info_selection d-flex justify-content-end align-items-center align-items-md-start">
								<button class="btn-gift-selection" type="button" data-id="${item.id}" ${disabled ? "disabled" : ""}>
									Chọn
								</button>
							</div>
						</div>
					</div>
				`);
			});
		}
	}
	
	function updateGiftByPriceQuantity() {
		const giftByPrices = $(".gift-by-price");
		for (let i = 0; i < giftByPrices.length; i += 1) {
			const quantity = giftByPrices.eq(i).find(".ajaxcart__qty-num").val();
			const btnGroupDoc = giftByPrices.eq(i).find(".input-group-btn");
			giftByPrices.eq(i).find(".grid-qty").html(`<span>Số lượng: ${quantity}</span>${btnGroupDoc.prop('outerHTML')}`)
		}
	}
	
	function updateGiftByPriceFixPrice(cart) {
		const giftByPrices = $(".gift-by-price");
		for (let i = 0; i < giftByPrices.length; i += 1) {
			const dataLine = giftByPrices.eq(i).find(".cart_product").data("line");
			const currentCartItem = cart.items[dataLine - 1];
			if (currentCartItem) {
				const giftItem = giftListAll.find(item => item.id === currentCartItem.id);
				if (giftItem) {
					const cartPrice1 =  giftByPrices.eq(i).find(".grid-price-1");
					cartPrice1.html(`
						<div class="new-price">0đ</div>
						<div class="old-price" style="color: #8A8A8F;text-decoration-line: line-through;">${formarCurrencyVND(giftItem.giftPrice)}đ</div>
					`);
				}
			}
		}
	}
	
	$(".CartPageContainer").on("click", ".btn-gift-selection", function() {
		$(".btn-gift-selection").prop("disabled", true);
		const dataId = $(this).data("id");
		const quantity = parseInt($(this).parents(".item-gift").find(".ajaxcart__qty-num").val());
		const currentItem = giftListAll.find(item => item.id === dataId);
		if (currentItem) {
			const currVariant = currentItem.variants.find(item => item.inventory_quantity >= quantity);
			if (currVariant) {
				const form = {
					"option-0": currVariant.options[0],
					"option-1": currVariant.options[1],
					"variantId": currVariant.id,
					"quantity": quantity,
				}
				jQuery.ajax({
					type: 'POST',
					url: '/cart/add.js',
					data: form,
					dataType: 'json',
					success: function(response) {
						//console.log(response);
						Bizweb.getCart(cartUpdateCallback);	
					}
				});
			}
		}
	});
	
	$(".CartPageContainer").on("click", "#popup_ask_select_gift_cancel", function() {
		$("#popup_ask_select_gift").addClass("d-none");
	});
	
	$(".CartPageContainer").on("click", "#popup_ask_select_gift_checkout", function() {
		check_inventory(1);
	});

	formOverride = function () {
		$formContainer.on('submit', function(evt) {
			evt.preventDefault();
			var flagChecked = false;
			$formContainer.find('.select-swatch .size').each(function (){
				if($(this).find('input').is(':checked')) {
					flagChecked = true;
				}
			})
			if($formContainer.find('.select-swatch .size').length == 0) {
				flagChecked = true;
			}
			if(!flagChecked) {
				//$('.wrap-notification-no-select-size').addClass('active');
				$('.swatch-size').addClass('not-selected');
				//setTimeout(function() {
				//	$('.wrap-notification-no-select-size').removeClass('active');
				//},3000)
				return false;
			}
			
			$addToCart.removeClass('is-added').addClass('is-adding');
			$('.qty-error').remove();
			Bizweb.addItemFromForm(evt.target, itemAddedCallback, itemErrorCallback);
			setTimeout(function(){
				//check_number_gift_mb ()
				check_number_free_delivery()
			},1000);
		});
	};

	itemAddedCallback = function (product) {
		$addToCart.removeClass('is-adding').addClass('is-added');
		Bizweb.getCart(cartUpdateCallback);
		$nameItemAdd.html(product.title).attr('href', product.url, 'title', product.title);
	};

	itemErrorCallback = function (XMLHttpRequest, textStatus) {
		var data = eval('(' + XMLHttpRequest.responseText + ')');
		$addToCart.removeClass('is-adding is-added');

		$cartContainer.trigger('ajaxCart.updatedQty');

		if (!!data.message) {
			if (data.status == 422) {
				$errorsContainer.html('<div class="errors qty-error">'+ data.description +'</div>')
			}
		}
	};

	cartUpdateCallback = function (cart) {
		// Update quantity and price
		buildCart(cart);
		updateCountPrice(cart);

	};
	function getProductInfo(url) {
		return new  Promise(function(resolve, reject){
			jQuery.getJSON(url+'.json', function (data, textStatus) {
					resolve(data);
			})
		})				
	}

	buildCart = function (cart) {
		// Start with a fresh cart div
		var itemListScrollTop = $('.CartHeaderContainer .ajaxcart__inner').scrollTop(),
			itemPopupScrollTop = $('.cartPopupContainer .ajaxcart__inner').scrollTop(),
			itemSideCartScrollTop = $('.CartSideContainer .ajaxcart__inner').scrollTop();
		//
		// Show empty cart
		if (cart.item_count === 0) {
			$cartContainer.empty();
			$cartContainer.append('<div class="cart--empty-message"><img src="//bizweb.dktcdn.net/100/438/408/themes/899432/assets/blank_cart.svg?1678673568653" alt="cart"/><p>Giỏ hàng của bạn trống</p><a href="/account" class="logincart">Đăng nhập/Đăng ký</a><span class="clearfix"></span><a class="buy-now" href="/collections/all">Mua ngay</a></div>');
			$countItem.html('0');
			$('.cartbar-mobile').attr('data-count-pr', '0');
			cartCallback(cart);
			$('.backdrop__body-backdrop___1rvky, .cart-sidebar, #popup-cart-desktop, .popup-cart-mobile').removeClass('active');
			$('.CartSideContainer').html('');			
			return;
		}

		// Handlebars.js cart layout
		var wW = $(window).width(),
			items = [],
			item = {},
			data = {},
			sourceSideCart = $("#SideCartTemplate").html(), // lấy template sidebar cart
			sourceCartTemp = $("#CartTemplate").html(), // lấy template page cart
			sourceCartInventoryTemp = $("#CartTemplateUpsell").html(), // lấy template page cart inventory
			soureCartLoadingTemp = $("#CartLoadingTemplate").html(), // lấy template loading cart
			soureCartLoadingMobileTemp = $("#CartLoadingMobileTemplate").html(),
			sourceCartMobileTemp = $("#CartMobileTemplate").html(), // lấy template page cart mobile
			sourceCartInventoryMobileTemp = $("#CartMobileTemplateUpsell").html(), // lấy template page cart mobile
			sourceCartHeaderTemp = $("#CartHeaderTemplate").html(), // lấy template header cart
			sourceCartPopTemp = $("#CartPopupTemplate").html(), // lấy template popup cart
			templateSideCart = Handlebars.compile(sourceSideCart), // biên dịch
			templateCartPage = Handlebars.compile(sourceCartTemp), // biên dịch
			templateCartInventoryPage = Handlebars.compile(sourceCartInventoryTemp), // biên dịch
			templateCartLoading = Handlebars.compile(soureCartLoadingTemp), // biên dịch
			templateCartLoadingMobile = Handlebars.compile(soureCartLoadingMobileTemp), 
			templateCartPop = Handlebars.compile(sourceCartPopTemp), // biên dịch
			templateCartMobile = Handlebars.compile(sourceCartMobileTemp),
			templateCartInventoryMobile = Handlebars.compile(sourceCartInventoryMobileTemp),
			templateCartHeader = Handlebars.compile(sourceCartHeaderTemp); // biên dịch
		// Add each item to our handlebars.js data
		//$cartContainerPage.append(templateCartLoading);
		//$cartContainerMobile.append(templateCartLoadingMobile);
		$.each(cart.items, function(index, cartItem) {

			// lấy ảnh check xem có ảnh không
			var prodImg = Bizweb.resizeImage(cartItem.image, 'compact');
			if(prodImg=="null" || prodImg =='' || prodImg ==null){
				prodImg = 'https://bizweb.dktcdn.net/thumb/compact/assets/themes_support/noimage.gif';
			}

			// lấy properties cart
			if (cartItem.properties !== null) {
				$.each(cartItem.properties, function(key, value) {
					if (key.charAt(0) === '_' || !value) {
						delete cartItem.properties[key];
					}
				});
			}

			var unitPrice = null;
			if (cartItem.unit_price_measurement) {
				unitPrice = {
					addRefererenceValue:
					cartItem.unit_price_measurement.reference_value !== 1,
					price: Bizweb.formatMoney(
						cartItem.unit_price, settings.moneyFormat
					),
					reference_value: cartItem.unit_price_measurement.reference_value,
					reference_unit: cartItem.unit_price_measurement.reference_unit
				};
			}
			//console.log(cartItem, 'hdhdh');
			// Create item's data object and add to 'items' array
			// check variant title có không
			var variant_title = cartItem.variant_title;
			if (variant_title === 'Default Title')
				variant_title = '';
			// gán giá trị cho từng key của template
			if (cartItem.price == 0) {
				var giftClass = 'gift',
					price = 'Quà tặng';
				if(isEventGiftByPriceHappening) {
					giftClass = "gift-by-price";
					variant_title = "";
					price = "0đ";
				}
			} else {
				var giftClass = '',
					price = Bizweb.formatMoney(cartItem.price, theme.settings.moneyFormat);
			}
			var aliasItem = cartItem.url.replace('/','')
			item = {
				id: cartItem.product_id,
				variantId: cartItem.variant_id,
				line: index + 1, // Bizweb uses a 1+ index in the API
				url: cartItem.url,
				alias: aliasItem,
				key: cartItem.key,
				img: prodImg,
				gift: giftClass,
				name: cartItem.title,
				variation: variant_title,
				sellingPlanAllocation: cartItem.selling_plan_allocation,
				properties: cartItem.properties,
				itemAdd: cartItem.quantity + 1,
				itemMinus: cartItem.quantity - 1,
				itemQty: cartItem.quantity,
				price: price,
				pricePrimitive: cartItem.price,
				disabledAdd: "",
				isShowPriceOriginal: cartItem.line_price_orginal > cartItem.price ? true : false,
				priceClass: cartItem.line_price_orginal > cartItem.price ? "cart-price-red" : "",
				//priceOriginal: Bizweb.formatMoney(cartItem.line_price_orginal, theme.settings.moneyFormat),
				priceTotal: Bizweb.formatMoney(cartItem.quantity*cartItem.price, theme.settings.moneyFormat),
				priceTotalOriginal: cartItem.quantity*cartItem.price,
				vendor: cartItem.vendor,
				unitPrice: unitPrice,
				linePrice: Bizweb.formatMoney(cartItem.line_price, theme.settings.moneyFormat),
				originalLinePrice: Bizweb.formatMoney(cartItem.original_line_price, theme.settings.moneyFormat),
				deletedClass: "",
			};
			//if (isEventGiftByPriceHappening) {
				//if(isGiftDeleting && selectedGifts.find(selectedGiftItem => selectedGiftItem.variantId === item.variantId)) {
					//item.deletedClass = "d-none";
				//}
			//}
			items.push(item);
		});
		itemCarts = items
		var promises = [];
		var productIds = [];
		var totalPriceAvailable = 0;
		var path = window.location.pathname;
		if(path.includes('/cart')) {
			for(var i = 0; i < items.length; i++) {
				if(!productIds.includes(items[i].id)) {
					promises.push(getProductInfo(items[i].url));
					productIds.push(items[i].id);
				}

			}
		}
		
		itemAvailables = [];
		itemNotAvailables = [];
		
		Promise.all(promises).then((results) => {
			var countNguyenGia = 0;
			var countNotNguyenGia = 0;
			for(var i = 0; i < items.length; i++) {
				for(var j = 0; j < results.length; j++){
					if(items[i].id == results[j].id){
						for(var k = 0; k < results[j].variants.length; k++){
							if(results[j].variants[k].id == items[i].variantId){
								if(items[i].pricePrimitive < results[j].variants[k].compare_at_price) {
									items[i].isShowPriceOriginal = true;
									items[i].priceOriginal = Bizweb.formatMoney(results[j].variants[k].compare_at_price, theme.settings.moneyFormat);
									items[i].priceClass =  "cart-price-red";									
									countNotNguyenGia++;
								}
								else {
									items[i].isShowPriceOriginal = false;
									items[i].priceClass =  "";	
									countNguyenGia += items[i].itemQty
									items[i].nguyengiaClass =  "nguyen-gia-price";
								}
								if(items[i].itemQty >= results[j].variants[k].inventory_quantity){
									items[i].disabledAdd = "disabled";
								}
								if(results[j].variants[k].available && results[j].variants[k].inventory_quantity >= items[i].itemQty) {
									itemAvailables.push(items[i]);
									totalPriceAvailable += items[i].priceTotalOriginal;
								}
								else {
									itemNotAvailables.push(items[i]);
								}
							}
						}
					}
				}				
			}
			if(countNotNguyenGia == 0) {
				countNguyenGia = countNguyenGia -1;
			}
			var activeSp2 = "";
			var activeSp3 = "";
			var activeSp4 = "";
			var percentWidth = "0%";
			var textNoti = "-5% khi mua sản phẩm nguyên giá";
			var textNoti1 = "Yay! Chương trình Mua Deal Ưu Đãi đã được bạn kích hoạt"
			if(countNguyenGia >= 1) {
				activeSp2 = "active";
				percentWidth = "35%";
				textNoti = "-10% cho sản phẩm nguyên giá tiếp theo";
				textNoti1 = "Yay! Bạn có 01 sản phẩm sẽ được giảm giá"
			}
			if(countNguyenGia >= 2) {
				activeSp3 = "active";
				percentWidth = "70%";
				textNoti = "-15% cho sản phẩm nguyên giá tiếp theo";
				textNoti1 = "Yay! Bạn có 02 sản phẩm sẽ được giảm giá"
			}
			if(countNguyenGia >= 3) {
				activeSp4 = "active";
				percentWidth = "100%";
				textNoti = "-15% khi mua mọi sản phẩm nguyên giá";
				textNoti1 = `Yay! Bạn đã nhận được mức giảm giá tối đa 15% áp dụng với 0${countNguyenGia} sản phẩm`
			}
			itemNotVailablesOld = itemNotAvailables;
						
			//isEventGiftByPriceHappening = false;
			if (isEventGiftByPriceHappening) {
				const cart = {
					items: items,
				}
				if (eventProductList.length === 0) {
					const pageLength = 5;
					const productPromises = [];
					for (let page = 1; page <= pageLength; page += 1) {
						productPromises.push(getPromise(`/collections/dai-tiec-tri-an/products.json?page=${page}&limit=200`));
					}
					Promise.all([
						...productPromises,
						getPromise("/collections/test-qua-tang-100k/products.json?limit=1000"),
						getPromise("/collections/test-qua-tang-200k/products.json?limit=1000"),
						getPromise("/collections/test-qua-tang-300k/products.json?limit=1000"),
						getPromise("/collections/test-qua-tang-400k/products.json?limit=1000")
					]).then(function(results) {
						let counter = 0;
						for (let i = 0; i < pageLength; i += 1) {
							eventProductList = [...eventProductList, ...results[i].products];
							counter = i;
						}
						gift100 = results[counter + 1].products.map(item => ({...item, giftPrice: 100000}));
						gift200 = results[counter + 2].products.map(item => ({...item, giftPrice: 200000}));
						gift300 = results[counter + 3].products.map(item => ({...item, giftPrice: 300000}));
						gift400 = results[counter + 4].products.map(item => ({...item, giftPrice: 400000}));
						renderGifts(cart);
						updateGiftByPriceQuantity();
						updateGiftByPriceFixPrice(cart);
					});
				} else {
					setTimeout(function() {
						renderGifts(cart);
						updateGiftByPriceQuantity();
						updateGiftByPriceFixPrice(cart);
					}, 200);
				}
			}
			data = {
				items: items,
				itemAvailables: itemAvailables,
				itemNotAvailables: itemNotAvailables,
				exitsNotAvailable: itemNotAvailables.length > 0 ? true : false,
				note: cart.note,
				activeSp2: activeSp2,
				activeSp3: activeSp3,
				activeSp4: activeSp4,
				percentWidth: percentWidth,
				textNoti: textNoti,
				textNoti1: textNoti1,
				totalPriceAvailable: Bizweb.formatMoney(totalPriceAvailable, theme.settings.moneyFormat),
				totalPrice: Bizweb.formatMoney(cart.total_price, theme.settings.moneyFormat),
				textPayment: checkClickBackToCart ? 'Đặt hàng sản phẩm còn hàng' : 'Đặt hàng'
			}
			$cartContainerPage.html(templateCartInventoryPage(data));
			if(wW < 768) {
				$(".buyxgety-module-mobile").html($(".buyxgety-module-desktop").html());
				setTimeout(function() {
					if($(".sapo-buyxgety-module-cart-v2").html() !== '') {
						$(".gift-list-header-mobile").removeClass('d-none');
						$(".buyxgety-module-desktop").addClass('d-none');
					}
				},1000)
				
			}
			else {
				$(".buyxgety-module-desktop").removeClass('d-none');
				$(".buyxgety-module-mobile").addClass('d-none');
				setTimeout(function() {
					if($(".sapo-buyxgety-module-cart-v2").html() !== '') {
						$(".gift-list-header-desktop").removeClass('d-none');
						$(".buyxgety-module-mobile").addClass('d-none');
					}
				},1000)
			}
			
			if (wW > 1200) {
				 // chèn line item vào template cart page
				//$cartPopup.append(templateCartPop(data));  // chèn line item vào template cart header
				//$cartContainerSidebar.append(templateSideCart(data)); // chèn line item vào template cart sidebar
			}
			if (wW < 1199) {
				//$cartContainerMobile.html(templateCartInventoryMobile(data));  // chèn line item vào template cart mobile
			}
			if (wW > 992) {
				$cartContainerHeader.html(templateCartHeader(data));  // chèn line item vào template cart header
			}
			$('.cart-item.gift').each(function() {
				var cart_url = $(this).find('.ajaxcart__product-name').attr('href');
				$('.add_to_cart_gift[data-url="'+cart_url+'"]').html('Đã chọn').addClass('picked');
			});	

			// Gather all cart data and add to DOM
			// Xuất items, ghi chú, tổng giá
			if (cart.total_price >= 498000) {
				$('.ship-cart-mobile').html('<span>Đủ điều kiện <b>miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</b> <i class="pick-gift">Click vào đây để chọn quà tặng</i>.</span>');
				$('.ship-cart-cart span').html('Đủ điều kiện nhận <a href="/chinh-sach-giao-nhan-hang-online">miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a> <i class="pick-gift">Click vào đây để chọn quà tặng</i>.');
				$('.ship-cart-head span').html('Đủ điều kiện nhận <a href="/chinh-sach-giao-nhan-hang-online">miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a> <a href="/cart" class="click">Click vào đây để chọn quà tặng</a>.')
				$('.delivery-cart span').html('Đủ điều kiện nhận <b>vận chuyển miễn phí</b>');
				/*
				var selector = ".buy-gift .container";
				getContentGift('danh-muc-qua-tang', selector);
				*/

			} else {
				var freeship = Bizweb.formatMoney(498000 - cart.total_price, theme.settings.moneyFormat);
				$('.ship-cart-mobile').html('<span>Mua thêm <b>'+freeship+'</b> để được <a href="/chinh-sach-giao-nhan-hang-online"> <b>tặng miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</b></span>');
				$('.ship-cart span').html('Mua thêm <b>'+freeship+'</b> để được <a href="/chinh-sach-giao-nhan-hang-online"> tặng miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a>')
				$('.delivery-cart span').html('Mua thêm <b>'+freeship+'</b> để đủ điều kiện nhận <b>vận chuyển miễn phí</b>')
										  /*
				$('.buy-gift .container').html('');
				*/
			}

			if (cart.total_price > 0) {
				$('.gift-cart-mobile span').html('Bạn nhận được một món quà <b>Miễn phí</b>')
			} else {
				var gifcart = Bizweb.formatMoney(0 - cart.total_price, theme.settings.moneyFormat);
				$('.gift-cart-mobile span').html('Mua thêm <b class="money">'+gifcart+'</b> để nhận được một món quà <b>MIỄN PHÍ</b>')
			}

			$countItem.html(cart.item_count);  // Đếm số lượng sp đang có trong giỏ hàng
			$('.cart-drop').attr('data-total', cart.total_price);
			$('.cartbar-mobile').attr('data-count-pr', cart.item_count);
			if(itemNotAvailables.length > 0) {
				var countAvailables = 0;
				for(var i =0; i < itemAvailables.length; i++){
					countAvailables += itemAvailables[i].itemQty;
				}
				$('.CartPageContainer .count_item_pr').text(countAvailables);
				$('.CartMobileContainer .count_item_pr').text(countAvailables);
			}
			else {
				$('.CartPageContainer .count_item_pr').text(cart.item_count);
				$('.CartMobileContainer .count_item_pr').text(cart.item_count);
			}
			$('.CartHeaderContainer .ajaxcart__inner').scrollTop(itemListScrollTop);
			$('.cartPopupContainer .ajaxcart__inner').scrollTop(itemPopupScrollTop);
			$('.CartSideContainer .ajaxcart__inner').scrollTop(itemSideCartScrollTop);
			cartCallback(cart);
		}).catch((e) => {
			data = {
				items: items,
				note: cart.note,
				totalPrice: Bizweb.formatMoney(cart.total_price, theme.settings.moneyFormat)
			}
			if (wW > 1200) {
				$cartContainerPage.html(templateCartPage(data));  // chèn line item vào template cart page
				$cartPopup.append(templateCartPop(data));  // chèn line item vào template cart header
				$cartContainerSidebar.append(templateSideCart(data)); // chèn line item vào template cart sidebar
			}
			if (wW < 1199) {
				$cartContainerMobile.html(templateCartMobile(data));  // chèn line item vào template cart mobile
			}
			if (wW > 992) {
				$cartContainerHeader.html(templateCartHeader(data));  // chèn line item vào template cart header
			}
			$('.cart-item.gift').each(function() {
				var cart_url = $(this).find('.ajaxcart__product-name').attr('href');
				$('.add_to_cart_gift[data-url="'+cart_url+'"]').html('Đã chọn').addClass('picked');
			});	

			// Gather all cart data and add to DOM
			// Xuất items, ghi chú, tổng giá
			if (cart.total_price >= 498000) {
				$('.ship-cart-mobile').html('<span>Đủ điều kiện <b>miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</b> <i class="pick-gift">Click vào đây để chọn quà tặng</i>.</span>');
				$('.ship-cart-cart span').html('Đủ điều kiện nhận <a href="/chinh-sach-giao-nhan-hang-online">miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a> <i class="pick-gift">Click vào đây để chọn quà tặng</i>.');
				$('.ship-cart-head span').html('Đủ điều kiện nhận <a href="/chinh-sach-giao-nhan-hang-online">miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a> <a href="/cart" class="click">Click vào đây để chọn quà tặng</a>.')
				$('.delivery-cart span').html('Đủ điều kiện nhận <b>vận chuyển miễn phí</b>');
				/*
				var selector = ".buy-gift .container";
				getContentGift('danh-muc-qua-tang', selector);
				*/

			} else {
				var freeship = Bizweb.formatMoney(498000 - cart.total_price, theme.settings.moneyFormat);
				$('.ship-cart-mobile').html('<span>Mua thêm <b>'+freeship+'</b> để được <a href="/chinh-sach-giao-nhan-hang-online"> <b>tặng miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</b></span>');
				$('.ship-cart span').html('Mua thêm <b>'+freeship+'</b> để được <a href="/chinh-sach-giao-nhan-hang-online"> tặng miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!</a>')
				$('.delivery-cart span').html('Mua thêm <b>'+freeship+'</b> để đủ điều kiện nhận <b>vận chuyển miễn phí</b>')
										  /*
				$('.buy-gift .container').html('');
				*/
			}

			if (cart.total_price > 0) {
				$('.gift-cart-mobile span').html('Bạn nhận được một món quà <b>Miễn phí</b>')
			} else {
				var gifcart = Bizweb.formatMoney(0 - cart.total_price, theme.settings.moneyFormat);
				$('.gift-cart-mobile span').html('Mua thêm <b class="money">'+gifcart+'</b> để nhận được một món quà <b>MIỄN PHÍ</b>')
			}

			$countItem.html(cart.item_count);  // Đếm số lượng sp đang có trong giỏ hàng
			$('.cart-drop').attr('data-total', cart.total_price);
			$('.cartbar-mobile').attr('data-count-pr', cart.item_count);
			$('.CartPageContainer .count_item_pr').text(cart.item_count);
			$('.CartMobileContainer .count_item_pr').text(cart.item_count);
			$('.CartHeaderContainer .ajaxcart__inner').scrollTop(itemListScrollTop);
			$('.cartPopupContainer .ajaxcart__inner').scrollTop(itemPopupScrollTop);
			$('.CartSideContainer .ajaxcart__inner').scrollTop(itemSideCartScrollTop);
			cartCallback(cart);
		})
	};

	cartCallback = function(cart) {
		$cartContainer.trigger('ajaxCart', cart);
	};

	adjustCart = function () {
		// Delegate all events because elements reload with the cart

		// Thêm giảm số lượng
		$cartContainer.on('click', '.items-count', function() {
			if (isUpdating) return;


			var $el = $(this),
				line = $el.data('line'),
				$qtySelector = $el.siblings('.number-sidebar'),
				qty = parseInt($qtySelector.val().replace(/\D/g, ''));

			var qty = validateQty(qty);

			// Add or subtract from the current quantity
			if ($el.hasClass('ajaxcart__qty--plus')) {
				if ($(this).parents('.ajaxcart__row').hasClass('gift')) {
					var number_gift = 0;
					var total = parseInt(parseInt($('.main-cart-page .total-price').text().replace(/\.|đ/g,''))/498000);
					$('.cart-item.gift').each(function() {
						var number = parseInt($(this).find('.number-sidebar').val());
						number_gift = number_gift + number;
					});
					if(number_gift >= total ) {									
						alert('Bạn đã chọn đủ quà. Xin cám ơn!');
					} else {
						qty += 1;
					}
				} else {
					qty += 1;
				}
			} else {
				if ($(this).parents('.ajaxcart__row').hasClass('gift')) {
					if ($(this).next().val() == 1) {
						var href = $(this).parents('.ajaxcart__row').find('.ajaxcart__product-name').attr('href');
						$('.add_to_cart_gift[data-url="'+href+'"]').html('<i class="fa fa-plus"></i> Chọn sản phẩm').removeClass('picked');
					}
				}
				qty -= 1;
				if (qty <= 0) qty = 0;
								
				if (isEventGiftByPriceHappening) {
					isGiftDeleting = true;
				}
			}

			// If it has a data-line, update the cart.
			// Otherwise, just update the input's number
			if (line) {
				if(qty == 0) {
					$('.wrap-popup-confirm-delete').addClass('show');
					var productName = $el.parents('.ajaxcart__row').find('.ajaxcart__product-name').html();
					$("#product-cart-line").attr("data-line",line);
					$('.popup-confirm-delete .product-name').html(productName)
					return;
				}
				updateQuantity(line, qty);
			} else {
				$qtySelector.val(qty);
			}

			setTimeout(function(){
				//check_number_gift_mb ()
				check_number_free_delivery()
			},1000);
		});

		// Update quantity based on input on change
		$cartContainer.on('change', '.number-sidebar', function() {
			if (isUpdating) return;

			var $el = $(this),
				line = $el.data('line'),
				qty = parseInt($el.val().replace(/\D/g, ''));

			var qty = validateQty(qty);

			// If it has a data-line, update the cart
			if (line) {
				if(qty == 0) {
					$('.wrap-popup-confirm-delete').addClass('show');
					var productName = $el.parents('.ajaxcart__row').find('.ajaxcart__product-name').html();
					$("#product-cart-line").attr("data-line",line);
					$('.popup-confirm-delete .product-name').html(productName)
					return;
				}
				updateQuantity(line, qty);
			}
		});

		$cartContainer.on('click', '.remove-item-cart', function(evt) {
			var $el = $(this),
				line = $el.data('line'),
				qty = 0;
			if(line) {
				if(qty == 0) {
					$('.wrap-popup-confirm-delete').addClass('show');
					var productName = $el.parents('.ajaxcart__row').find('.ajaxcart__product-name').html();
					$("#product-cart-line").attr("data-line",line);
					$('.popup-confirm-delete .product-name').html(productName)
					return;
				}
				updateQuantity(line, qty);
			}
			if ($(this).parents('.ajaxcart__row').hasClass('gift')) {
				var href = $(this).parents('.ajaxcart__row').find('.ajaxcart__product-name').attr('href');
				$('.add_to_cart_gift[data-url="'+href+'"]').html('<i class="fa fa-plus"></i> Chọn sản phẩm').removeClass('picked');
			}
			var id = $(this).parents('.ajaxcart__row').data('id');
			$('.module-content-buyxgety .item-product[data-product-id="'+id+'"] .btn-addtocart-buyxgety').removeClass('added').text('Thêm vào giỏ hàng');
			setTimeout(function(){
				//check_number_gift_mb ()
				check_number_free_delivery()
			},1000);
		});

		$cartContainer.on('focus', '.number-sidebar', function(evt) {
			var $el = $(evt.target);
			$el[0].setSelectionRange(0, $el[0].value.length);
		});

		// Prevent cart from being submitted while quantities are changing
		$cartContainer.on('submit', 'form.ajaxcart', function(evt) {
			if (isUpdating) {
				evt.preventDefault();
			}
		});

		// Highlight the text when focused
		$cartContainer.on('focus', '.items-count', function() {
			var $el = $(this);
			setTimeout(function() {
				$el.select();
			}, 50);
		});
		
		//confirm delete
		$('.btn-confirm-delete').click(function() {
			$('.btn-confirm-delete').attr("disabled","disabled");
			var line = $("#product-cart-line").attr("data-line");	
			if (isEventGiftByPriceHappening) {
				isGiftDeleting = true;
			}
			setTimeout(function() {
				Bizweb.changeItem(line, 0, function(cart) {
					$('.btn-confirm-delete').removeAttr("disabled");
					$("#product-cart-line").attr("data-line","");
					$('.wrap-popup-confirm-delete').removeClass('show');
					adjustCartCallback(cart);
				});
			}, 10);	
		})
		
		$('.btn-cancel-delete').click(function() {
			$("#product-cart-line").attr("data-line","");
			$('.wrap-popup-confirm-delete').removeClass('show');
		})

		function updateQuantity(line, qty) {
			isUpdating = true;

			// Add activity classes when changing cart quantities
			var $product = $('.ajaxcart__product[data-line="' + line + '"]').addClass('is-loading');

			if (qty === 0) {
				$product.parent().addClass('is-removed');
			}

			// Slight delay to make sure removed animation is done
			setTimeout(function() {
				Bizweb.changeItem(line, qty, adjustCartCallback);
			}, 10);

			$cartContainer.trigger('ajaxCart.updatingQty');
		}

		// Save note anytime it's changed
		$cartContainer.on('change', 'textarea[name="note"]', function() {
			var newNote = $(this).val();

			// Update the cart note in case they don't click update/checkout
			Bizweb.updateCartNote(newNote, function(cart) {});
		});
	};

	adjustCartCallback = function (cart) {
		// Update quantity and price
		updateCountPrice(cart);
		// Reprint cart on short timeout so you don't see the content being removed
		setTimeout(function() {
			isUpdating = false;
			Bizweb.getCart(buildCart);
		}, 150)
	};

	qtySelectors = function() {
		// Change number inputs to JS ones, similar to ajax cart but without API integration.
		// Make sure to add the existing name and id to the new input element
		var numInputs = $('input[type="number"][data-ajax-qty]');

		// Qty selector has a minimum of 1 on the product page
		// and 0 in the cart (determined on qty click)
		var qtyMin = 0;

		if (numInputs.length) {
			numInputs.each(function() {
				var $el = $(this),
					currentQty = $el.val(),
					inputName = $el.attr('name'),
					inputId = $el.attr('id');

				var itemAdd = currentQty + 1,
					itemMinus = currentQty - 1,
					itemQty = currentQty;

				var source   = $("#JsQty").html(),
					template = Handlebars.compile(source),
					data = {
						key: $el.data('id'),
						itemQty: itemQty,
						itemAdd: itemAdd,
						itemMinus: itemMinus,
						inputName: inputName,
						inputId: inputId
					};

				// Append new quantity selector then remove original
				$el.after(template(data)).remove();
			});

			// Setup listeners to add/subtract from the input
			$('.js-qty__adjust').on('click', function() {
				var $el = $(this),
					id = $el.data('id'),
					$qtySelector = $el.siblings('.js-qty__num'),
					qty = parseInt($qtySelector.val().replace(/\D/g, ''));

				var qty = validateQty(qty);
				qtyMin = $body.hasClass('template-product') ? 1 : qtyMin;

				// Add or subtract from the current quantity
				if ($el.hasClass('js-qty__adjust--plus')) {
					qty += 1;
				} else {
					qty -= 1;
					if (qty <= qtyMin) qty = qtyMin;
				}

				// Update the input's number
				$qtySelector.val(qty);
			});
		}
	};

	validateQty = function (qty) {
		if((parseFloat(qty) == parseInt(qty)) && !isNaN(qty)) {
			// We have a valid number!
		} else {
			// Not a number. Default to 1.
			qty = 1;
		}
		return qty;
	};

	module = {
		init: init,
		load: loadCart
	};

	return module;

}(ajaxCart || {}, jQuery));


$(window).on('load', function() {
	ajaxCart.init({
		moneyFormat: ''
	});
	ajaxCart.load();
});

$(document).ready(function ($) {	
	setTimeout(function(){
		//check_number_gift_mb ()
		check_number_free_delivery()
	},1000);
	$('.buy-gift').on('click','.add_to_cart_gift',function(){
		var total = parseInt(parseInt($('.cart-drop').attr('data-total'))/498000);
		var $this = $(this);
		var url = $(this).data('url');
		var variant_id = $(this).data('variant');
		var cart_rows = $('.cart-item');
		var sale_rows = $('.add_to_cart_gift');
		var canBuy = true;
		var number_gift = 0;
		$('.cart-item.gift').each(function() {
			var number = parseInt($(this).find('.number-sidebar').val());
			number_gift = number_gift + number;
		});
		if (total > 0 ) {
			if(number_gift >= total ) {				
				canBuy = false;									
				alert('Bạn đã chọn đủ quà. Xin cám ơn!');
			} else {
				cart_rows.each(function(index, cart) {
					var cart_url = $(cart).find('.ajaxcart__product-name').attr('href');
					if((url === cart_url)) {
						canBuy = false;									
						alert('Bạn đã chọn món quà này rồi, vui lòng chọn món quà khác!');
					}					
				});	
			}
		} else {
			var total = parseInt(parseInt($('.cart-drop').attr('data-total'))/498000);
			
			var extra = Bizweb.formatMoney(498000 - total, "{{amount_no_decimals_with_comma_separator}}đ");
			
			canBuy = false;
			alert('Vui lòng mua thêm '+extra+' để được tặng miễn phí 2 đôi tất, hoặc 1 áo ba lỗ, hoặc 1 túi canvas!');
		}
		if(canBuy) {
			$(this).html('Đã chọn').addClass('picked');
			var form = $this.parents('form');				
			$.ajax({
				type: 'POST',
				url: '/cart/add.js',
				async: false,
				data: form.serialize(),
				dataType: 'json',
				beforeSend: function() { },
				success: function(line_item) {
					$('.cart-popup-name').html(line_item.title).attr('href', line_item.url, 'title', line_item.title);
					ajaxCart.load();
					if (wW > 1200) {
						$('#popup-cart-desktops').addClass('active');
						$('.cart-drop').addClass('active');
						setTimeout(function(){
							$('.cart-drop').removeClass('active');
						}, 3000);
					}else {
						AddCartMobile(line_item);
					}
					
				},
				cache: false
			});
		}
	});
	$('.btn_close').on('click', function(){
		$('.pop_background').addClass('d-none');
		$('.pop_up').addClass('d-none');
	})
	$('.close_popup_warning').on('click', function(){
		$('.pop_background').addClass('d-none');
		$('.pop_up').addClass('d-none');
	})
	$('.main-cart-page').on('click','.cart__btn-proceed-checkout',function(){
		//check_number money ()
		var totals = parseInt(parseInt($('.total-price').text()));
		//console.log('moneyCounter', totals)
		if(totals == 0){
			$('.pop_background').removeClass('d-none');
			$('.pop_up').removeClass('d-none');
			return
		}
		//check_number_gift ()
		if (isEventGiftByPriceHappening && selectedGifts.length === 0 && moneyCounter > 499000) {
			$("#popup_ask_select_gift").removeClass("d-none");
		} else {
			check_inventory(1);
		}
		//check_inventory(1);
	});
	$(".main-cart-page").on('click','.btn-back-to-cart',function(e){
		e.preventDefault();
		$(".wrap-popup-confirm-payment").css('visibility','hidden');
		$('.popup-confirm-payment').css('visibility','hidden');
		$(".text-payment").text('Thanh toán sản phẩm còn hàng')		
		checkClickBackToCart = true;
		ajaxCart.load();
		setTimeout(() => {
			if($('.items-not-available').length > 0) {
				$('html, body').animate({ scrollTop: $('.items-not-available').offset().top - 100 }, 'slow');
			}
		},1500)
		
		//confirmPayment = true;
	}) 
	$(".main-cart-page").on('click','.show-condition-upsell',function(e) {
		$(".wrap-popup-condition-upsell").addClass('show');
		$(".popup-condition-upsell").css('visibility','visible')
	})
	$(".banner-upsell-product").click(function() {
		$(".wrap-popup-condition-upsell").addClass('show');
		$(".popup-condition-upsell").css('visibility','visible');
	})
	$(".close-popup-upsell").click(function() {
		$(".wrap-popup-condition-upsell").removeClass('show');
		$(".popup-condition-upsell").css('visibility','hidden')
	});
	$(".main-cart-page").on('click','.btn-go-to-payment',function(e){		
		e.preventDefault();
		check_inventory(2);
		//for(var i =0; i < itemNotAvailables.length; i++) {
			//var params = {
			//	type: 'POST',
			//	url: '/cart/change.js',
			//	data: 'quantity=' + 0 + '&line=' + itemNotAvailables[i].line,
			//	dataType: 'json',
			//	success: function(cart) {
			//	}
			//};
			//jQuery.ajax(params);
		//}
		//setTimeout(() => {
		//	window.location.href='/checkout';  
		//},1000)
	})
	
	
});

setTimeout(function(){
	$('body').on('click','.pick-gift, .timeline-gift .result a', function(){
		var location = $('.buy-gift').offset().top - 20;
		$("html, body").animate({
			scrollTop: location
		}, 500);
		return false;
	})
},1000);