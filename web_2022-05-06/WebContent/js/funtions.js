/**
 * 
 */
 function getParameters(name) {
	let value = undefined;
	
	let parameters = location.search;
	parameters = parameters.substr(1);
	
	parameters = parameters.split("&");
	for(let i=0; i<parameters.length; i++) {
		let parameter = parameters[i].split("=");
		
		let paramName = parameter[0];
		let paramValue = parater[1];
		
		if(paramName == name){
			value=paramValue;
			break;
		}
	}
	
	return value;
}