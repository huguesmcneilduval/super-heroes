FROM nginx
COPY config/nginx.conf /etc/nginx/conf.d/super-hero.conf
COPY build /usr/share/superhero/html
RUN apt-get update && apt-get install -y curl