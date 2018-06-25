# Report State Dashboard
This is a dashboard that developers can use to help them debug their smart home actions.
It will obtain data from the HomeGraph and present it to you, allowing you to verify the
data that is stored in it.

The app can be installed to Google App Engine or any Java Web Server.

Make sure to follow [this guide](https://developers.google.com/actions/smarthome/report-state) to get a service account key

You can add a Giphy [API key](https://developers.giphy.com/docs/) to `giphy.service.ts` to get animated images for each device type

## Setup

### Build client

First you need to build the web frontend that you will interact with:

```
cd src/main/ngapp
npm install
npm run build
# Built files will be added in src/main/webapp
```

### Build server

#### Using Google App Engine
To set up your instance:

1. Use the Google Cloud Console to create a [new App Engine application](https://console.cloud.google.com/projectselector/appengine/create?lang=java&st=true&_ga=2.118087439.-783977692.1527806171)
    1. When prompted, select the region where you want your App Engine application located.
1. Download and install the [Google Cloud SDK](https://cloud.google.com/sdk/docs/) if you haven't already
1. Download and install [Maven](https://cloud.google.com/appengine/docs/standard/java/tools/using-maven) if you haven't already
1. Configure the gcloud command-line environment:

```bash
gcloud init
gcloud auth application-default login
```

1. Install the App Engine component

```
gcloud components install app-engine-java
```

1. Verify that you are using the latest version of the Google Cloud SDK

```
gcloud components update
```

1. Deploy the sample with `mvn appengine:deploy`
    1. It will be available at `http://<your-project-id>.appspot.com`
    1. You can stream logs from the command line by running: `gcloud app logs tail -s default`

**Note**: You may have connectivity issues if you try to run the sample locally

Read the documentation on [App Engine](https://cloud.google.com/appengine/docs/standard/java/quickstart) to learn more.

#### Other Java Web Servers
To install on any other Java Web Server:

`mvn clean package`

Deploy the war artifact from `target/`

To run with embedded tomcat:

`mvn clean package`

Then run `java -jar [artifact_name].jar` from `target/`

## Build from source
To build from the source files:
1. Download the [home graph protos](https://github.com/googleapis/googleapis/tree/master/google/home/graph/v1) to `src/main/proto`
1. Download [annotations.proto and http.proto](https://github.com/googleapis/googleapis/tree/master/google/api). Put these files in `src/main/proto/google/api`.

# How to make contributions?
Please read and follow the steps in the CONTRIBUTING.md.

# License
See `LICENSE.md`.