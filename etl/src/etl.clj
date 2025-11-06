(ns etl
  (:require [clojure.string :as str]))


(defn transform
  [source]
  (into {}
        (for [[score letters] source
              letter letters]
          [(str/lower-case letter) score])))

;; or..

(defn- set-scores [table value letters]
  (reduce #(assoc %1 (str/lower-case %2) value) table letters))

(defn transform [source]
  (reduce-kv set-scores (sorted-map) source))