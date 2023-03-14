function setCookie(cName, cValue, expDays) {
	let date = new Date();
	date.setTime(date.getTime() + (expDays * 24 * 60 * 60 * 1000));
	const expires = "expires=" + date.toUTCString();
	document.cookie = cName + "=" + cValue + "; " + expires + "; path=/";
}
function getCookie(cName) {
	const name = cName + "=";
	const cDecoded = decodeURIComponent(document.cookie); //to be careful
	const cArr = cDecoded .split('; ');
	let res;
	cArr.forEach(val => {
		if (val.indexOf(name) === 0) res = val.substring(name.length);
	})
	return res;
}

var cookieget = getCookie('_landing_page');

var urlcheck = window.location.href;
if (urlcheck.includes('affcode') || urlcheck.includes('utm_source') || urlcheck.includes('utm_medium') || urlcheck.includes('utm_campaign') ||  urlcheck.includes('utm_id') || urlcheck.includes('utm_term') || urlcheck.includes('utm_content')) {
	var stringutm = window.location.search;
	var username = stringutm;
	setCookie('_landing_page', username, 15);
}