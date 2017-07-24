(defproject cider-diet "1.0.1"
  :description "Lightweight nREPL for cider"
  :url "://github.com/kovrik/cider-diet"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main cider.diet
  :aot [cider.diet]

  ;; TODO Check if we really need these plugins and deps
  :plugins [[thomasa/mranderson "0.4.7"]]

  :dependencies [[org.clojure/clojure "1.8.0"]

                 [cider/cider-nrepl "0.15.0"]
                 [org.clojure/tools.nrepl "0.2.13"]
                 [org.tcrawley/dynapath "0.2.5"]
                 ^:source-dep [mvxcvi/puget "1.0.1"]
                 ^:source-dep [fipp "0.6.9"]
                 ^:source-dep [compliment "0.3.4"]
                 ^:source-dep [cljs-tooling "0.2.0"]
                 ^:source-dep [cljfmt "0.5.6" :exclusions [org.clojure/clojurescript]]
                 ^:source-dep [org.clojure/java.classpath "0.2.3"]
                 ^:source-dep [org.clojure/tools.namespace "0.3.0-alpha3"]
                 ^:source-dep [org.clojure/tools.trace "0.7.9"]
                 ^:source-dep [org.clojure/tools.reader "1.0.0"]]
  )
