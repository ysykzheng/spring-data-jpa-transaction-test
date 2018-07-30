#!/usr/bin/env bash

curl "http://127.0.0.1:8080/list"

ab -c 50 -n100 "http://127.0.0.1:8080/test?name=333&sleep=1000"

ab -c 50 -n100 "http://127.0.0.1:8080/test2?name=333&sleep=1000"