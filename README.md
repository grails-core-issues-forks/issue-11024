# Grails issue 11024 #

Sample project for https://github.com/grails/grails-core/issues/11024

Start the app and execute:
```bash
curl -X POST -d '{"name":"Iván"}' -H 'Content-Type:application/json' localhost:8080/action1
```

The filter is created (and executed) twice and it still doesn't log the body:

```bash
:bootRun
2018-09-28 17:10:10.227 DEBUG --- [ost-startStop-1] o.s.w.f.CommonsRequestLoggingFilter      : Initializing filter 'logFilter'
2018-09-28 17:10:10.227 DEBUG --- [ost-startStop-1] o.s.w.f.CommonsRequestLoggingFilter      : Initializing filter 'logFilter'
2018-09-28 17:10:10.231 DEBUG --- [ost-startStop-1] o.s.w.f.CommonsRequestLoggingFilter      : Filter 'logFilter' configured successfully
2018-09-28 17:10:10.231 DEBUG --- [ost-startStop-1] o.s.w.f.CommonsRequestLoggingFilter      : Filter 'logFilter' configured successfully
Grails application running at http://localhost:8080 in environment: development


2018-09-28 17:10:40.230 DEBUG --- [nio-8080-exec-1] o.s.w.f.CommonsRequestLoggingFilter      : Before request [uri=/action1;client=127.0.0.1;headers={host=[localhost:8080], user-agent=[curl/7.47.0], accept=[*/*], content-length=[16], Content-Type=[application/json;charset=UTF-8]}]
2018-09-28 17:10:40.230 DEBUG --- [nio-8080-exec-1] o.s.w.f.CommonsRequestLoggingFilter      : Before request [uri=/action1;client=127.0.0.1;headers={host=[localhost:8080], user-agent=[curl/7.47.0], accept=[*/*], content-length=[16], Content-Type=[application/json;charset=UTF-8]}]
2018-09-28 17:10:40.727 DEBUG --- [nio-8080-exec-1] o.s.w.f.CommonsRequestLoggingFilter      : After request [uri=/action1;client=127.0.0.1;headers={host=[localhost:8080], user-agent=[curl/7.47.0], accept=[*/*], content-length=[16], Content-Type=[application/json;charset=UTF-8]}]
2018-09-28 17:10:40.727 DEBUG --- [nio-8080-exec-1] o.s.w.f.CommonsRequestLoggingFilter      : After request [uri=/action1;client=127.0.0.1;headers={host=[localhost:8080], user-agent=[curl/7.47.0], accept=[*/*], content-length=[16], Content-Type=[application/json;charset=UTF-8]}]
<===========--> 85% EXECUTING

```
