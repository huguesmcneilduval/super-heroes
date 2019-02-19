buildFrontend:
	./scripts/build-frontend.sh

buildBackend:
	./scripts/build-backend.sh

build: buildBackend buildFrontend