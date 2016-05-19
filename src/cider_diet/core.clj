(ns cider-diet.core
  (:require [clojure.tools.nrepl.server :as nrepl-server]
            [cider.nrepl :refer (cider-nrepl-handler)])
  (:gen-class))

(defn- start-server
  "Start cider-diet nREPL server"
  [port]
  (println "Starting cider-diet nREPL on port" port)
  (nrepl-server/start-server :port port :handler cider-nrepl-handler)
  (spit ".nrepl-port" (str port))
  (println "cider-diet nREPL started on port" port))

(defn -main
  "Start REPL"
  [& args]
  (let [port (or (and (first args) (Integer/parseInt (first args)))
                  7888)]
        (start-server port)))
