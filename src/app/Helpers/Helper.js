export default {
	isFunction: function (functionToCheck) {
		return functionToCheck && {}.toString.call(functionToCheck) === "[object Function]";
	},
}