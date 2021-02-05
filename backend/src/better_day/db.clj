(ns better-day.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [next.jdbc.result-set :as rs]))

(def db-spec {:dbtype "postgresql"
              :dbname "betterday"
              :user "btrdays"
              :password "t3stus@g3"})

(def ds (jdbc/get-datasource db-spec))

(defn get-categories
  []
  (jdbc/execute! ds
                 ["SELECT * FROM item_category"] 
                 {:builder-fn rs/as-unqualified-lower-maps}))

(defn get-items-for-category
  [category_id]
  (jdbc/execute! ds
                 ["SELECT *
                   FROM item
                   WHERE category_id = ?" category_id]
                 {:builder-fn rs/as-unqualified-lower-maps}))

(defn populate-bd-database
  [& args]
  (jdbc/execute! ds ["DROP TABLE item_category, item"])
  (jdbc/execute! ds
                 ["
                   CREATE TABLE item_category (
                     id SERIAL PRIMARY KEY,
                     name TEXT NOT NULL
                   )"])
  (jdbc/execute! ds
                 ["
                   CREATE TABLE item (
                     id SERIAL PRIMARY KEY,
                     summary TEXT NOT NULL,
                     description TEXT,
                     category_id INTEGER NOT NULL
                   )"])
  (sql/insert-multi! ds :item_category [:name]
                      [["Getting started"]
                       ["Outside"]
                       ["While working"]
                       ["After a long day"]
                       ["Before sleeping"]])
  (sql/insert-multi! ds :item [:summary :category_id]
                     [["Make your bed" 1]
                      ["Drink a glass of water" 1]
                      ["Brush your teeth" 1]
                      ["Tell your family, pet, or yourself \"I love you\"" 1]
                      
                      ["Open a door for a stranger" 2]
                      ["Be courteous to others" 2]
                      ["Take a moment to appreciate your surroundings" 2]
                      ["Greet your neighbors and coworkers, bus drivers, shop clerks, etc." 2]
                      
                      ["Make yourself a schedule for the day" 3]
                      ["Get up and get yourself something to drink" 3]
                      ["Face frustration/fatigue with a positive attitude" 3]
                      ["Take a moment to connect with your colleagues" 3]
                      
                      ["Take a short break" 4]
                      ["Do little bit of tidying up" 4]
                      ["Remember to eat something" 4]
                      ["Do something relaxing or entertaining" 4]
                      
                      ["Floss and brush your teeth" 5]
                      ["Make a list of the things that you feel grateful for today" 5]
                      ["Prepare for tomorrow" 5]
                      ["Meditate or go through a mindfulness/relaxation exercise" 5]]))