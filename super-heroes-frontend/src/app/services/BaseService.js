import http from "./HttpService";

const handleResponse = (response, cb) => {
    if (response.status >= 200 && response.status < 300) {
        cb(null, response.data);
    } else {
        cb({
            status: response.status || 500
        });
    }

};


export default class BaseService {

    constructor(path, schema) {
        this.path = path ? path : "/default/";
        this.schema = schema;
    }
    findAll(cb) {
        http.get(this.path)
            .then(response => handleResponse(response, cb));
    }

    findById(id, cb) {
        http.get(this.path + id)
            .then(response => handleResponse(response, cb));
    }

    create(object, cb) {
        http.post(this.path, null, object)
            .then(response => handleResponse(response, cb));

    }
    save(id, object, cb) {
        http.put(this.path + id, null, object)
            .then(response => handleResponse(response, cb));

    }

    delete(id, cb) {
        http.delete(this.path + id, null)
            .then(response => handleResponse(response, cb));
    }

    getSchema() {
        return this.schema;
    }
}