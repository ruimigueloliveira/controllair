# As in https://mherman.org/blog/dockerizing-a-react-app/
# pull official base image
FROM node:14.16.1-alpine
# set working directory
WORKDIR /react
# add `/react/node_modules/.bin` to $PATH
ENV PATH /react/node_modules/.bin:$PATH
# install react dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm ci reactstrap
RUN npm ci bootstrap
RUN npm ci jquery
RUN npm ci axios

# add react
COPY . ./
# start react
CMD ["npm", "start"]