(function() {
	var link = document.getElementByTagName("a")[0];
	link.onclick = function() {
		var xhr = new XMLHttpRequest(); //XHR Object
		
		//handle the 'onreadystatechange' event
		//xhr.readyState property values
		// 0 = uninitialized
		// 1 = loading
		// 2 = loaded
		// 3 = interactive
		// 4 = complete
		xhr.onreadystatechange = function() {
			if((xhr.readyState == 4) && (xhr.status == 200 || xhr.status == 304)) {
				xhr.responseText;
			}
		};
		
		//open request
		xhr.open("GET", "http://theuiguru.github.io/ponnasseril/blog.txt", true);
		
		//send request
		xhr.send(null);
		
		return false;
	};	
})();
