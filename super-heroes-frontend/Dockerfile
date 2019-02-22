FROM node as builder
COPY src .
COPY public .
COPY package.json .
COPY package-lock.json
RUN npm install
RUN npm run build
COPY build /usr/share/superhero/html

FROM nginx
COPY config/nginx.conf /etc/nginx/conf.d/super-hero.conf
COPY --from=builder /usr/share/superhero/html /usr/share/superhero/html

