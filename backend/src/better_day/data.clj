(ns better-day.data
  (:require [better-day.db :as db]
            [clojure.data.json :as json]))

(defn get-items-json
  []
  (json/write-str
   (map
    (fn [category]
      {(keyword (:name category))
       (db/get-items-for-category (:id category))})
    (db/get-categories))))