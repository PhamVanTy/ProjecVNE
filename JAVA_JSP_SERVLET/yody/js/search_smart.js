/*document.addEventListener('DOMContentLoaded', function() {

	var preLoadLoadGif = $('<div class="spinner-border text-primary" role="status"><span class="sr-only">Loading...</span></div>');
	var searchID = -1;
	var currReqObj = null;
	let $resultsBox
		
		$resultsBox = $('<div class="results-box"><div class="search-results"></div><div class="history"></div></div>').appendTo('.theme-search, .theme-searchs');
		
	

	$('.theme-search-smart .theme-header-search-form input[type="text"]').bind('keyup change', function(e){
		$('.results-box .search-results').html('');
		if($(this).val().trim().length > 0 && $(this).val().trim() != $(this).data('oldval')) {
			$(this).data('oldval', $(this).val());
			if(currReqObj != null) currReqObj.abort();
			clearTimeout(searchID);
			var $form = $(this).closest('form');
			var term = $form.find('input[name="query"]').val();
			var linkURL = $form.attr('action') + '?query=' + term;
			$resultsBox.find('.search-results').html('<div class="theme-loading"><div class="spinner-border text-primary" role="status"><span class="sr-only">Loading...</span></div></div>');
			searchID = setTimeout(function(){
					
				currReqObj = $.ajax({
					url: $form.attr('action'),
					async: false,
					data: {
						type: 'product',
						view: 'json',
						q: term
					},
					dataType: 'json',
					success: function(data){
						currReqObj = null;

						if(data.results_total == 0) {
							$resultsBox.find('.search-results').html('<div class="note">KhÃ´ng cÃ³ káº¿t quáº£ tÃ¬m kiáº¿m</div>');
						} else {
							$resultsBox.find('.search-results').empty();
							$.each(data.results, function(index, item){
								var xshow = 'wholesale';
								if(!(item.title.toLowerCase().indexOf(xshow) > -1)) {
									var $row = $('<a class="clearfix"></a>').attr('href', item.url).attr('title', item.title);
									$row.append('<div class="img"><img src="' + item.thumb + '" /></div>');
									$row.append('<div class="d-title">'+item.title+'</div>');
									$row.append('<div class="d-title d-price">'+item.price+'</div>');
									$resultsBox.find('.search-results').append($row);
								}
							});
							$resultsBox.find('.search-results').append('<a href="' + linkURL + '" class="note" title="Xem táº¥t cáº£">Xem táº¥t cáº£ <span class="allcount"></span></a>');
							$('.allcount').html("("+data.results_total+")");
						}
					}
				});
			}, 100);
		}  else if($(this).val().trim().length == 0) {
			$resultsBox.find('.search-results').empty();
		}
	}).attr('autocomplete', 'off').data('oldval', '').bind('focusin', function(){
		$resultsBox.fadeIn(200);
	}).bind('click', function(e){
		e.stopPropagation();
	});
	$('body').bind('click', function(){
		$resultsBox.hide();
	});
	$('#header-search-product').on('submit', function(e){
		//e.preventDefault();
		dataLayer.push({
			'event': 'pangoTrack',
			'eventAction': 'search_button',
			'cdpData': {
				properties: {
					'keywords': $(".search-bar .search-auto").val(),
					'username': ''
				}
			}
		})
		//$('#header-search-product').submit();

	});
	$('.theme-search-form').on('submit', function(e){
		e.preventDefault();
		var term = '*' + $(this).find('input[name="query"]').val() + '*';
		var linkURL = $(this).attr('action') + '?query=' + term ;
		window.location = linkURL;

	});

});*/