(ns mltagger.prod
  (:require [mltagger.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
