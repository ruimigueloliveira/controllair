# As in https://mherman.org/blog/dockerizing-a-react-app/
# pull official base image
FROM node:14.16.1-alpine
# set working directory
WORKDIR /Frontend
# add `/Frontend/node_modules/.bin` to $PATH
ENV PATH /Frontend/node_modules/.bin:$PATH
# install Frontend dependencies
COPY package.json ./
COPY package-lock.json ./
RUN npm install reactstrap
RUN npm install bootstrap
RUN npm install jquery
RUN npm install axios

# add Frontend
COPY . ./
# start Frontend
CMD ["npm", "start"]