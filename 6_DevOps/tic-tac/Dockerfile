# FROM mhart/alpine-node:latest
# WORKDIR /app
# COPY package.json .
# RUN npm install

FROM mhart/alpine-node:latest
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY . .
RUN npm install
EXPOSE 5173
CMD ["npm", "run", "dev"]