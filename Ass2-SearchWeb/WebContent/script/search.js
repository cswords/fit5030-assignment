/**
 * 
 */

$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

var listquery = {
	"q" : "Hello",
	"target" : "Google",
	"pageSize" : 10,
	"pageNumber" : 1
};

function runRestfulService() {
	try {
		listquery.q = encodeURIComponent(listquery.q);
		var url = "./search?query=" + JSON.stringify(listquery);
		// alert(url);
		$('#' + listquery.target).load(url);
	} catch (ex) {
		alert(ex.message);
	}
}

function submitquery() {
	var oldq = listquery.q;
	listquery = $('#listForm').serializeObject();
	runRestfulService();
	if (!(listquery.q == oldq)) {
		listquery.target = "Twitter";
		listquery.days = 5;
		runRestfulService();
	} else {
		// alert("Twitter result is not updated.");
	}
}

function nextPage() {
	listquery = $('#listForm').serializeObject();
	listquery.pageNumber = listquery.pageNumber * 1 + 1;
	runRestfulService();
	document.getElementById('pageNumber').value = listquery.pageNumber;
}

function lastPage() {
	listquery = $('#listForm').serializeObject();
	if (listquery.pageNumber > 1) {
		listquery.pageNumber = listquery.pageNumber * 1 - 1;
		runRestfulService();
		document.getElementById('pageNumber').value = listquery.pageNumber;
	}
}
