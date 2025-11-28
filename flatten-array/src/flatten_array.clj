(ns flatten-array
  (:require [clojure.core :as core]))

(defn flatten
  "Flattens the given sequential collection.
  Nil values are excluded from the result."
  [coll]
  (filter identity (core/flatten coll)))

;; or

;; using tree-seq
(defn flatten
  [coll]
  (->> (tree-seq sequential? seq coll)
       (filter (complement sequential?))
       (filter identity)))

;; using reduce
(defn flatten [coll]
  (reduce (fn [acc node] (concat acc (cond
                                       (coll? node) (flatten node)
                                       (nil? node) []
                                       :else [node]))) [] coll))