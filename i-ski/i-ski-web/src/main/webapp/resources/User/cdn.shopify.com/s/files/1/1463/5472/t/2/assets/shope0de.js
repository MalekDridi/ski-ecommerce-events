jQuery(function($){

	$('html').removeClass('no-js'); 




	// OUTDATED MSIE NOTIFICATION
	if ( $.browser.msie && $.browser.version >= 8 && $.browser.version <= 10 ) {
		$('body').prepend('<div class="old_browsers"><a href="//windows.microsoft.com/en-us/internet-explorer/download-ie"><i class="fa fa-warning"></i><b>You are using an outdated version of Internet Explorer.</b><span>For a faster, safer browsing experience</span><span class="btn">upgrade now</span> </a></div>');
	};




	// PRELOADER
	$(window).load(function() {
		$('#page_preloader').addClass('off');

		setTimeout( function() { 
			$('#page_preloader').hide()
		}, 600 );
	});




	// IOS HOVER
	if ((navigator.userAgent.match(/iPhone/i)) || (navigator.userAgent.match(/iPod/i)) || (navigator.userAgent.match(/iPad/i))) {
		$('a').on("touchstart", function() {});
	};




	// PLACEHOLDER JS 
	$('[placeholder]').each(function(){
	  if ($(this).val() === '') {
		var hint = $(this).attr('placeholder');
		$(this).val(hint).addClass('hint');
	  }
	});

	$('[placeholder]').focus(function() {
	  if ($(this).val() === $(this).attr('placeholder')) {
		$(this).val('').removeClass('hint');
	  }
	}).blur(function() {
	  if ($(this).val() === '') {
		$(this).val($(this).attr('placeholder')).addClass('hint');
	  }
	});




	// RTE YOUTUBE VIDEO
	$('.rte iframe[src *= youtube]').wrap('<div class="youtube_wrap"></div>');




	// FORM VALIDATION MINI
	$.fn.formValidation=function(){this.find("input, textarea").after('<p class="alert-form-info"></p>'),this.on("submit",function(t){if($(this).find("input, textarea").each(function(){""==$(this).val()&&($(this).addClass("alert-form").next().html("Field can&#39;t be blank").slideDown(),$(this).on("focus",function(){$(this).removeClass("alert-form").next().slideUp()}),t.preventDefault())}),$(this).find("input[type=email]").length){var e=$(this).find("input[type=email]");e.val().length>0&&(e.val().length<6||-1==e.val().indexOf("@")||-1==e.val().indexOf("."))&&(e.addClass("alert-form").next().html("Incorrect email").slideDown(),e.on("focus",function(){$(this).removeClass("alert-form").next().slideUp()}),t.preventDefault())}if(2==$(this).find("input[type=password]").length){var n=$(this).find("input[type=password]:eq(0)"),i=$(this).find("input[type=password]:eq(1)");n.val()!=i.val()&&(i.addClass("alert-form").next().html("Passwords do not match").slideDown(),i.on("focus",function(){i.removeClass("alert-form").next().slideUp()}),t.preventDefault())}})};


   

	// FORM STYLES   
	$('.address_table form, .customer_address form').addClass('form-horizontal');




	// CUSTOM SELECTS 
	$('.header_currency select, #navigation select').styler();
	$('.jq-selectbox__trigger').append('<i class="fa fa-angle-down"></i>');




	// SEARCH FORMS
	$('.search_form').on('submit', function(e) {
		var searchQuery = $(this).find('input').val().replace(/ /g, '+');
		var placeHolder = $(this).find('input').attr('placeholder').replace(/ /g, '+');

		if ( !(searchQuery.length && searchQuery != placeHolder) ) {
			e.preventDefault();
			e.stopPropagation();
		};
	});


	// HEADER SEARCH
	$('#search_trigger').on('click', function(e) {
		e.stopPropagation();

		if( $('#search_form').hasClass('search_off') ) {
			$('#search_form').removeClass('search_off').addClass('search_on');
		};

		if( $('#currencies-styler').hasClass('opened') ) {
			$('#currencies-styler').removeClass('opened');
			$('#currencies-styler .jq-selectbox__dropdown').hide();
		};
	});

	$(document).on('click', function(){
		$('#search_form').removeClass('search_on').addClass('search_off');
	});

	$('#search_form').on('click', function(e) {
		e.stopPropagation();
	});




	// BACK TO TOP BUTTON 
	$(document).ready(function(){
		$(document.body).append('<a id="back_top" href="#"></a>');
		$('#back_top').hide();

		$(window).scroll(function(){
			if ( $(this).scrollTop() > 300 ) {
				$('#back_top').fadeIn("slow");
			}
			else {
				$('#back_top').fadeOut("slow");
			};
		});

		$('#back_top').on('click', function(e) {
			e.preventDefault();
			$('html, body').animate({scrollTop : 0},800);
			$('#back_top').fadeOut("slow").stop();
		});
	});




	// PRODUCT QUANTITY FORM MINI, USED ON:
	// 1. PRODUCT PAGE
	// 2. PRODUCT QUICK VIEW
	// 3. CART PAGE
	$(document).on("focusout",".quantity_input",function(){var t=$(this).val();$(this).val(isNaN(parseFloat(t))&&!isFinite(t)||0==parseInt(t)||""==t?1:parseInt(t)<0?parseInt(t)-2*parseInt(t):parseInt(t))}),$(document).on("click",".quantity_up",function(){var t=$(this).parent().find(".quantity_input");t.val(!isNaN(parseFloat(t.val()))&&isFinite(t.val())?parseInt(t.val())+1:1)}),$(document).on("click",".quantity_down",function(){var t=$(this).parent().find(".quantity_input");t.val(!isNaN(parseFloat(t.val()))&&isFinite(t.val())&&t.val()>1?parseInt(t.val())-1:1)});



	// MEGAMENU 
	$(document).ready(function(){
		$("#megamenu_trigger").on('click', function(e) {
			e.preventDefault();

			$("#megamenu").removeClass('megamenu_off').addClass('megamenu_on');
		});

		$("#megamenu_close").on('click touchstart', function(e) {
			e.preventDefault();

			$("#megamenu").addClass('megamenu_off').removeClass('megamenu_on');
		});

		$('#megamenu.megamenu_mobile').bind('mousewheel DOMMouseScroll', function(e) {
			var scrollTo = null;

			if (e.type == 'mousewheel') {
				scrollTo = (e.originalEvent.wheelDelta * -1);
			}
			else if (e.type == 'DOMMouseScroll') {
				scrollTo = 40 * e.originalEvent.detail;
			};

			if (scrollTo) {
				e.preventDefault();
				$(this).scrollTop(scrollTo + $(this).scrollTop());
			};
		});
	});




	// MEGAMENU TOGGLE
	var mobFlag = 0;

	megamenuToggle = function() {
		if ( $(window).width() > 991 ) {
			$('#megamenu').removeClass('megamenu_mobile').addClass('megamenu_desktop');

			$('#megamenu .level_1').superfish({
				animation: {height: 'show'},
				speed: 'fast'
			});

			$('#megamenu .level_1, #megamenu .level_3').removeAttr('style');

			// $('#megamenu_mobile_toggle').unbind('.mobileMenu');

			$('.level_1_trigger').unbind('.mobileMenu');
			$('.level_2_trigger').unbind('.mobileMenu');

			$(document).unbind('.mobileMenu');

			mobFlag = 0;
		}
		else {
			$('#megamenu').removeClass('megamenu_desktop').addClass('megamenu_mobile');

			$('#megamenu .level_1').superfish('destroy');

			if ( mobFlag == 0 ) {
				menuMobile();
				mobFlag = 1;
			};
		};
	};

	$(window).on('load resize', function() {
		megamenuToggle();
	});




	// MEGAMENU MOBILE
	menuMobile = function() {
		// $("#megamenu_mobile_toggle").on('click.mobileMenu', function(){
		// 	$(".level_1").stop().slideToggle("slow");

		// 	$(this).toggleClass("active");
		// });

		$('.level_1_trigger').on('click.mobileMenu', function() {
			$(this).parent().parent().find('.level_2_wrap').slideToggle('slow');

			$(this).toggleClass('active');

			return false;
		});

		$('.level_2_trigger').on('click.mobileMenu', function(){
			$(this).parent().find('.level_3').slideToggle('slow');

			$(this).toggleClass('active');

			return false;
		});

		// $('.megamenu_mobile h2').on('click touchstart', function(e){
		// 	e.stopPropagation();
		// });

		// $(document).bind('click.mobileMenu', function(){
		// 	$(".level_1").slideUp("slow");
		// 	$(".megamenu_mobile").find("h2").removeClass("active");
		// });
	};




	// STICKY MENU
	function onElementHeightChange( elm, callback ) {
		var lastHeight = elm.clientHeight, newHeight;

		(function run(){
			newHeight = elm.clientHeight;
			if( lastHeight != newHeight )
				callback();
			lastHeight = newHeight;

			if( elm.onElementHeightChangeTimer )
				clearTimeout(elm.onElementHeightChangeTimer);

			elm.onElementHeightChangeTimer = setTimeout(run, 500);
		})();
	};


	function stickUP( target ) {

		$('<div class="pseudo_block" style="position:relative;display:block;"></div>').insertAfter( target );

		pseudoBlock = $('.pseudo_block');

		thisOffsetTop = parseInt( target.offset().top );
		thisOuterHeight = parseInt( target.outerHeight( true ) );

		onElementHeightChange(document.body, function(){
			thisOffsetTop = parseInt( target.offset().top );
			thisOuterHeight = parseInt( target.outerHeight( true ) );
		});

		$(document).on('scroll', function() {
			tmpScrolled = $(this).scrollTop();

			documentScroll = parseInt( $(this).scrollTop() );

			if ( thisOffsetTop < documentScroll ) {
				target.addClass('megamenu_stuck').css({ 'position' : 'fixed', 'top' : 0 });
				pseudoBlock.css({ 'height' : thisOuterHeight });
			}
			else {
				target.removeClass('megamenu_stuck').css({ 'position' : 'relative', 'top' : 'auto' });
				pseudoBlock.css({ 'height' : 0 });
			};

		}).trigger('scroll');

	};

	$(window).on('load', function() {
		stickUP( $('#page_header') );
	});



























});