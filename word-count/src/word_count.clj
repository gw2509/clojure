(ns word-count
  (:require [clojure.string :as str]))

(def word-regex #"[a-z0-9]+(?:'[a-z]+)*")
(def word-regex #"\w+(?:'\w+)*")

(defn my-frequencies
  [coll]
  (reduce (fn [acc w] (if (contains? acc w)
                        (assoc acc w (inc (get acc w)))
                        (assoc acc w 1))) {} coll))

(defn word-count
  "Counts how many times each word occurs in the given string."
  [s]
  (->> s
       str/lower-case
       (re-seq word-regex)
       my-frequencies))