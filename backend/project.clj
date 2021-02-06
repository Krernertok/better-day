(defproject better_day "0.1.0-SNAPSHOT"
  :description "Better Day"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [metosin/reitit "0.5.11"]
                 [ring/ring-jetty-adapter "1.8.2"]
                 [org.clojure/data.json "1.0.0"]
                 [seancorfield/next.jdbc "1.1.613"]
                 [org.postgresql/postgresql "42.2.10"]]
  :main better-day.core
  :target-path "target/%s"
  :repl-options {:init-ns better_day.core})
