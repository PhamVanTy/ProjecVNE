$(document).ready(function(){
	setTimeout(function(){ 
		SwatchGrid();
	},1000);
});

$("body").on('click', '.btn-num', function() {
	let l = parseInt($(this).parent('.swatch-color').attr('data-scroll')),
		v = $(this).parent('.swatch-color').attr('data-view') - 1;
	if (!l) {
		l = 0;
	}
	let k = l + parseInt((v * 40) - 10);
	$(this).parent('.swatch-color').animate({
		scrollLeft: k
	}, 500)
	return false;
})
initSwatchColor();
function initSwatchColor() {
	$('.swatch-color').each(function() {
		var itemProduct = $(this).closest('.item_product_main');
		var productId = $(itemProduct).attr('data-productid');
		var dataElement = $(itemProduct).find(`.product-json-${productId}`);
		var product = $(dataElement).length ? $.parseJSON($(dataElement).val()) : '';
		var activeColor = false;
		if(product !== "") {
			$(this).find('.swatch-element').each(function() {
				var flagAvailable = false;
				var color = $(this).attr('data-value');
				for(var i = 0; i < product.variants.length; i++) {
					if(color == product.variants[i].option1 && product.variants[i].available) {
						flagAvailable = true;
						if(!activeColor) {
							$(this).find('input').prop('checked',true);
							var imgoptnew = $(this).find('label').data('scolor');
							if( imgoptnew != ''){
								$(this).closest('form').find('.image_thumb img').attr('data-src', imgoptnew);
							}
							activeColor = true;
						}
					}
				}
				if(!flagAvailable) {
					$(this).addClass('d-none');
				}
			})
		}
	})
}
function SwatchGrid() {
	if ($('.swatch-color').length) {
		
		var w_attr = $('.option-swath').width() + 10,
			disp = Math.floor(w_attr / 40);
		
		$('.swatch-color').each(function() {
			var st = $(this).scrollLeft(),
				swatch = $(this).attr('data-swatches');
			$(this).attr('data-view', disp);
			if (swatch > disp) {
				//$(this).append('<span class="btn-num">•••</span>');
			}
		})
		$('.swatch-color').scroll(function() {
			var st = $(this).scrollLeft(),
				swatch = $(this).attr('data-swatches');
			$(this).attr('data-scroll', st);
			if (swatch > disp) {
				let hin = (swatch - disp) * 40 - 10;
				if (st >= hin) {
					//$(this).removeClass('fakeLoad').find('.btn-num').remove();
				} else {
					if (!$(this).hasClass('fakeLoad')) {
						//$(this).addClass('fakeLoad').append('<span class="btn-num">•••</span>');
					}
				}
			}
			return false;
		})
	}
	var gridon = $('.item_product_main').not('.no-swatch').length;
	
	
	
	$(document).on('click','.option-swath .swatch-element.color label',function(){
		$(this).parent('.swatch-element').find('input').prop('checked',true);
		var imgoptnew = $(this).data('scolor');
		if( imgoptnew != ''){
			//var htmlImg = $(this).closest('.swatch-element').find('.img-product-thumbnail').html();
			//$(this).closest('form').find('.image_thumb').html(htmlImg)
			$(this).closest('form').find('.image_thumb img').attr('src', imgoptnew);
		}
	
	})
	$('.item_product_main').not('.no-swatch').map(function() {
		var thispro = $(this),
		    Ego_ = $(this),
			dataurl = $(this).data('url'),
			dataid = $(this).data('id');
		
		var EgoCallback = function(variant, selector){
			if (variant){
				var form = Ego_;
				for(var i=0,length=variant.options.length; i<length; i++){
					var radioButton = form.find('.swatch[data-option-index="' + i + '"] :radio[value="' + variant.options[i] +'"]');
				};
			};
			var addToCarter = Ego_.find('.btn-buy.addcart'),
				btnNower = Ego_.find('.btn-buy-now-grid'),
				former = Ego_.find('.btn-buy'),
				salelabel = Ego_.find('.product-thumbnail'),
				productPricer = Ego_.find('.price'),
				comparePricer = Ego_.find('.compare-price'),
				addnow = 'MUA NGAY',
				addone = '<span>THÊM VÀO GIỎ HÀNG</span>';

			if (variant && variant.available) {
				salelabel.removeClass('sale');
				former.removeClass('d-none');
				btnNower.removeAttr('disabled').removeClass('d-none');
				addToCarter.html(addone).removeAttr('disabled');
				if(variant.price == 0){
					productPricer.html('Liên hệ');
					comparePricer.hide();
					former.addClass('d-none');
				}else{
					former.removeClass('d-none');	
					productPricer.html(Bizweb.formatMoney(variant.price, theme.settings.moneyFormat));
														  addToCarter.html(addone);
									   if ( variant.compare_at_price > variant.price ) {
						comparePricer.html(Bizweb.formatMoney(variant.compare_at_price, theme.settings.moneyFormat)).show();
															  var discount = Math.ceil((variant.compare_at_price - variant.price)/variant.compare_at_price*100);
						if (discount > 99) {
							var pt = 99;
						} else {
							var pt = discount
							}
						salelabel.addClass('sale').attr('data-sale', '-'+pt+'%');
					}else {
						comparePricer.hide();   
					}       										
				};
			}else{	
				salelabel.removeClass('sale');
				btnNower.attr('disabled', 'disabled').addClass('d-none');
				addToCarter.html('Hết hàng').attr('disabled', 'disabled');
				if(variant){
					if(variant.price != 0){
						former.removeClass('d-none');
						btnNower.attr('disabled', 'disabled').addClass('d-none');
						productPricer.html(Bizweb.formatMoney(variant.price, theme.settings.moneyFormat));
															  if ( variant.compare_at_price > variant.price ) {
										   comparePricer.html(Bizweb.formatMoney(variant.compare_at_price, theme.settings.moneyFormat)).show();
										   var discount = Math.ceil((variant.compare_at_price - variant.price)/variant.compare_at_price*100);
						if (discount > 99) {
							var pt = 99;
						} else {
							var pt = discount
							}
						salelabel.addClass('sale').attr('data-sale', '-'+pt+'%');
					} else {
						comparePricer.hide();  
					}     
				}else{
					productPricer.html('Liên hệ');
					comparePricer.hide();
					former.addClass('d-none');};
			}else{
				productPricer.html('Liên hệ');
				comparePricer.hide();
				former.addClass('d-none');
			};
		}
		};
		
		function changeSwatch() {
			if($(this).find('.selector-wrapper').length <= 1) {
				var product_json = '';
				$.ajax ({
					async: false,
					type: "GET",
					url: "/collections/all/products"+dataurl+"?view=json",
					dataType: "json",
					success: function(data) {
						product_json = data;
					}
				})
				new Bizweb.OptionSelectors('product-grid-selectors-'+dataid, {
					product: product_json,
					onVariantSelected: EgoCallback, 
					enableHistoryState: true
				});  
			}
		}


		Ego_.find('.swatch :radio').change(function() {
			changeSwatch();
			var optionIndexs = jQuery(this).closest('.swatch').attr('data-option-index');
			var optionValues = jQuery(this).val();
			jQuery(this)
				.closest('form')
				.find('.single-option-selector')
				.eq(optionIndexs)
				.val(optionValues)
				.trigger('change');
			
		});
	});
}