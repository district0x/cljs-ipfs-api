(ns cljs-ipfs-api.core
  (:require [taoensso.timbre :as timbre :refer-macros [log
                                                       trace
                                                       debug
                                                       info
                                                       warn
                                                       error
                                                       fatal
                                                       report]]
            [cljs.nodejs :as nodejs]
            [cljsjs.ipfs :as ipfs]))

(def *ipfs-instance* (atom nil))

(defn init-ipfs-web [param]
  (let [i (new js/IpfsApi param)]
    (reset! *ipfs-instance* i)
    i))

(defn init-ipfs-node [param]
  (let [ipfs-api (nodejs/require "ipfs-api")
        i (new ipfs-api param)]
    (reset! *ipfs-instance* i)
    i))

(defn init []
  (info "INIT"))
