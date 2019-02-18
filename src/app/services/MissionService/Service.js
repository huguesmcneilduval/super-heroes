import BaseService from "../BaseService";

import { Schema } from ".";

const PATH = "/mission/";

export class SuperHeroService extends BaseService {
	constructor() {
		super(PATH, Schema);
	}

}

export default new SuperHeroService();