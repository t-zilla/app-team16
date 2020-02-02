FROM node:13.7.0 AS build-stage

COPY frontend /frontend
WORKDIR /frontend
RUN npm install && npm run build


FROM nginx:1.17.8

COPY --from=build-stage /frontend/build/ /build
COPY devops/prod/config/nginx/conf.d /etc/nginx/conf.d
