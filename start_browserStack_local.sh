#!/bin/bash

echo "BrowserStackLocal instances:"

if pidof BrowserStackLocal; then

        ./BrowserStackLocal snb9nJ6K6UQsRUZX1bs3 &
else
    echo "BrowserStack pid not found,  initialising BrowserStack"

        if [[ "$OSTYPE" == "linux-gnu" ]]; then
        if [ ! -e BrowserStackLocal ]; then
        wget -0 https://www.browserstack.com/browserstack-local/BrowserStackLocal-linux-x64.zip
        unzip BrowserStackLocal-linux-x64.zip
        fi
       ./BrowserStackLocal 5pTvC3CBdkwiNpujzwYa &

        elif [[ "$OSTYPE" == "darwin"* ]]; then
           echo "downloading mac osx browsetstack driver..."
           if [ ! -e BrowserStackLocal ]; then
        wget  https://www.browserstack.com/browserstack-local/BrowserStackLocal-darwin-x64.zip
        unzip BrowserStackLocal-darwin-x64.zip
        fi
       ./BrowserStackLocal snb9nJ6K6UQsRUZX1bs3 &

        else
           echo "OS not supported"
        fi
  fi