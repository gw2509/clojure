(ns word-count2
  (:require [clojure.string :as str]))

(defn word-count
  "Counts how many times each word occurs in the given string."
  [s]
  (->> (str/lower-case s)
       (re-seq #"[a-z0-9]+(?:'[a-z]+)*")
       frequencies))


(defn my-frequencies
  [coll]
  (reduce (fn [acc w] (if (contains? acc w)
                        (assoc acc w (inc (get acc w)))
                        (assoc acc w 1))) {} coll))

(defn word-count
  [s]
  (->> (str/lower-case s)
       (re-seq #"[a-z0-9]+(?:'[a-z]+)*")
       my-frequencies))