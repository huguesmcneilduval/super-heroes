const PREFIX_URL = "/api";

export class Fetch {
	get (_URL, options) {
		var url = _URL,
			params = (options && options.params) || {};
		let paramsKeys = Object.keys(params);
		let index = 0;
		if(paramsKeys.length > 0 ) {
			url = url + "?";
			Object.keys(params).forEach(key => {
				url = url + `${key}=${params[key]}${index + 1 < paramsKeys.length ? "&" : ""}`;
				index++;
			});
		}
	
    	return this.doFetch(url, {
    		...options,
    		method: "GET"
    	});
	}
	post (url, options, payload) {
		return this.doFetch(url, {
    		...options,
    		method: "POST"
    	}, payload);
	}
	put (url, options, payload) {
		return this.doFetch(url, {
    		...options,
    		method: "PUT"
    	}, payload);
	}
	delete (url, options) {
		return this.doFetch(url, {
    		...options,
    		method: "DELETE"
    	});
	}

	doFetch(url, options, payload) {

		let payloadJson = "";
		try {
			payloadJson = JSON.stringify(payload);
		}
		catch (err) {
			console.log("JSONgnify payload failed");
		}

		const headers = {
			"Content-Type": "application/json;charset=UTF-8",
			...options.headers,
		};
		const handleError = response => {
			if (!response.ok)
				throw response;

			return response;
		};

		return fetch(PREFIX_URL + url, {
			...options,
			headers: headers,
			body: payloadJson
		})
			.then(handleError)
			.then(function (response) {
				return response.text().then(function (text) {
					return text ? JSON.parse(text) : {};
				}).then(data => {
					return {
						status: response.status,
						data: data
					};
				});
			})
			.catch(this.businessLogic);
	}
}

export default new Fetch();