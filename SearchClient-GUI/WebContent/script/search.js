/**
 * 
 */
function query() {
	var query = document.getElementById("searchText").value;
	query = encodeURIComponent(query);
	var psize = document.getElementById("pageSize").value;
	var pnum = document.getElementById("pageNumber").value;
	var from = document.getElementById("fromDate").value;
	var to = document.getElementById("toDate").value;

	if (document.getElementById("dogoogle").checked) {
		var qgoogleweb = './service?qtype=googleweb&page=' + pnum + '&size='
				+ psize + '&q=' + query;
		$('#googleweb').load(qgoogleweb);
	} else {
		$('#googleweb').html('');
	}
	if (document.getElementById("doyahoo").checked) {
		var qyahooweb = './service?qtype=yahooweb&page=' + pnum + '&size='
				+ psize + '&q=' + query;
		$('#yahooweb').load(qyahooweb);
	} else {
		$('#yahooweb').html('');
	}
	if (document.getElementById("doyoutube").checked) {
		var qyoutube = './service?qtype=youtube&page=' + pnum + '&size='
				+ psize + '&q=' + query;
		$('#youtube').load(qyoutube);
	} else {
		$('#youtube').html('');
	}
	if (document.getElementById("doflickr").checked) {
		var qflickr = './service?qtype=flickr&page=' + pnum + '&size=' + psize
				+ '&q=' + query;
		if (from.length > 0)
			qflickr += '&from=' + encodeURIComponent(from);
		if (to.length > 0)
			qflickr += '&to=' + encodeURIComponent(to);
		$('#flickr').load(qflickr);
	} else {
		$('#flickr').html('');
	}
	if (document.getElementById("dopicasa").checked) {
		var qpicasa = './service?qtype=picasa&page=' + pnum + '&size=' + psize
				+ '&q=' + query;
		if (from.length > 0)
			qpicasa += '&from=' + encodeURIComponent(from);
		if (to.length > 0)
			qpicasa += '&to=' + encodeURIComponent(to);
		$('#picasa').load(qpicasa);
	} else {
		$('#picasa').html('');
	}
}

function nextPage() {
	var pnum = document.getElementById("pageNumber").value;
	pnum = Number(pnum);
	document.getElementById("pageNumber").value = pnum + 1;
	pnum = pnum + 1;
	query();
}

function lastPage() {
	var pnum = document.getElementById("pageNumber").value;
	pnum = Number(pnum);
	if (pnum > 1) {
		document.getElementById("pageNumber").value = pnum - 1;
		pnum = pnum - 1;
		query();
	}
}

var pickerOpts = {
 dateFormat: "dd/mm/yy"
};

$(document).ready(function() {
	$("#fromDate").datepicker(pickerOpts);
});

$(document).ready(function() {
	$("#toDate").datepicker(pickerOpts);
});