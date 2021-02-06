(ns better-day.handlers
  (:require [better-day.data :as data]))

(def cors-headers {"Access-Control-Allow-Origin" "*"
                   "Access-Control-Allow-Headers" "Origin, Accept, Access-Control-Request-Method, Access-Control-Allow-Headers, Content-Type, *"})

(defn items-handler
  [_]
  {:status 200
   :headers (merge cors-headers {"Content-Type" "application/json"})
   :body (data/get-items-json)})
