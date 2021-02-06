(ns better-day.core
  (:require
   [better-day.handlers :as handlers]
   [ring.adapter.jetty :as jetty]
   [reitit.ring :as ring])
  (:gen-class))
 
(def app
  (ring/ring-handler
   (ring/router
    [["/api"
      ["/items"
       {:get {:handler handlers/items-handler}}]]])
   
   (ring/create-default-handler
    {:not-found (constantly {:status 404 :body "Page not found"})})))

(defn start-server
  []
  (let [port 3001]
    (jetty/run-jetty #'app {:port port :join? false})
    (println "Running Better Days backend server on port " port)))

(defn -main
  [& args]
  (start-server))