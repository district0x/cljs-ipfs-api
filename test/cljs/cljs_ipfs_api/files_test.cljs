(ns cljs-ipfs-api.files-test
  (:require-macros [cljs.test :refer [deftest testing is async]])
  (:require [cljs.test :as t]
            [taoensso.timbre :as timbre :refer-macros [log
                                                       trace
                                                       debug
                                                       info
                                                       warn
                                                       error
                                                       fatal
                                                       report]]
            [cljs-ipfs-api.core :as core]
            [cljs-ipfs-api.files :as files]))

(deftest add-test []
  (async done
         (core/init-ipfs-node "/ip4/127.0.0.1/tcp/5001")
         (let [fs (js/require "fs")
               file (.createReadStream fs "/home/wambat/work/district0x/cljs-ipfs-api/test/resources/testfile.jpg")]
           (files/add file (fn [err files]
                             (is (= err nil))
                             (info ["DONE" err files])
                             (done))))))
(deftest ls-test []
  (async done
         (core/init-ipfs-node "/ip4/127.0.0.1/tcp/5001")
         (files/fls "/ipfs/QmYwAPJzv5CZsnA625s3Xf2nemtYgPpHdWEz79ojWnPbdG/"
                   (fn [err files]
                     (is (= err nil))
                     (info ["DONE" err files])
                     (done)))))
