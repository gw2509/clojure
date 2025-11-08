(ns pangram
  (:require [clojure.string :as str]))

(defn pangram?
  "Returns true if the given string is a pangram;
  otherwise, it returns false."
  [s]
  (= 26
     (count (into #{} (re-seq #"[a-z]" (str/lower-case s))))))


(defn pangram?
  [s]
  (= 26
   (->> s
        str/lower-case
        (re-seq #"[a-z]")
        set
        count)))


(defn pangram? [s]
  (= 26
     (->> s
         str/lower-case
         (re-seq #"[a-z]")
         frequencies
         count)))