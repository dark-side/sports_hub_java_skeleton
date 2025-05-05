# Sports-Hub Application Back-End

## Project Description

This is a draft pet project for testing Generative AI on different software engineering tasks. It is planned to evolve and grow over time. Specifically, this repo will be a Java playground. The application's legend is based on the sports-hub application description from the following repo: [Sports-Hub](https://github.com/dark-side/sports-hub).

## Available Front-End applications
- [React.js](https://github.com/rtriska/reactjs_fe_plgrnd)

## Dependencies

- Docker
- Docker Compose

The mentioned dependencies can be installed using the official documentation [here](https://docs.docker.com/compose/install/).

## Project back-end stack and toolset
It includes Spring Boot 3.3.x, Postgres, Docker.

## Step-by-Step setup Guide

### 1. Clone the Repositories

To run the web application with the React front-end, clone the following repositories within the same folder:

```sh
git clone git@github.com:rtriska/java_be_genai_plgrnd.git
git clone https://github.com/rtriska/reactjs_fe_plgrnd.git
```

#### 2. Spin up the service
- Start docker containers (`-d` for detached mode to unblock the terminal)
  ```
  docker compose up -d
  ```
  If you'd like to watch services logs running in the terminal, run without `-d`.

### 3. Check the app in browser

The project should be available by URL:
- Mac, Linux - `http://localhost:3000/`
- Windows - `http://127.0.0.1:3000/`


#### Some useful commands
- To stop services
  ```
  docker compose down
  ```

- To build or start particular service
  ```
  docker compose build <service>
  ```
  ```
  docker compose start <service>
  ```

## License

Licensed under either of

- [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0)
- [MIT license](http://opensource.org/licenses/MIT)

Just to let you know, at your option.

## Contribution

Unless you explicitly state otherwise, any contribution intentionally submitted for inclusion in your work, as defined in the Apache-2.0 license, shall be dual licensed as above, without any additional terms or conditions.

**Should you have any suggestions, please create an Issue for this repository**