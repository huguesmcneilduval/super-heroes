FROM nginx
RUN npm install
RUN npm run build
COPY config/nginx.conf /etc/nginx/conf.d/super-hero.conf
COPY build /usr/share/superhero/html
