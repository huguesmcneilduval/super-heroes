FROM node as builder
WORKDIR /tmp/dockerbuild
COPY src ./src
COPY public ./public
COPY package.json ./
COPY package-lock.json ./
RUN npm install
RUN npm run build

FROM nginx
COPY config/nginx.conf /etc/nginx/conf.d/super-hero.conf
COPY --from=builder /tmp/dockerbuild/build /usr/share/superhero/html

