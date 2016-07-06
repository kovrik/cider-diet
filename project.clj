(defproject cider-diet "0.1.0-SNAPSHOT"
  :description "Lightweight nREPL for cider"
  :url "://github.com/kovrik/cider-diet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main cider.diet
  :aot [cider.diet]

  ;; TODO Check if we really need these plugins and deps
  :plugins [[thomasa/mranderson "0.4.7"]]

  :dependencies [[org.clojure/clojure "1.8.0"] 

                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.tcrawley/dynapath "0.2.3"]
                 [cider/cider-nrepl "0.12.0"]

                 ^:source-dep [mvxcvi/puget "1.0.0"]
                 ^:source-dep [fipp "0.6.4"]
                 ^:source-dep [compliment "0.2.8-SNAPSHOT"]
                 ^:source-dep [cljs-tooling "0.2.0"]
                 ^:source-dep [cljfmt "0.4.1" :exclusions [org.clojure/clojurescript]]
                 ^:source-dep [org.clojure/java.classpath "0.2.3"]
                 ^:source-dep [org.clojure/tools.namespace "0.2.11"]
                 ^:source-dep [org.clojure/tools.trace "0.7.9"]
                 ^:source-dep [org.clojure/tools.reader "0.10.0"]]
  )
