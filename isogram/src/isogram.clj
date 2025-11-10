(ns isogram
  (:require [clojure.string :as str]))


(defn isogram?
  "Returns true if the given string is an isogram;
  otherwise, it returns false."
  [s]
  (if (empty? s)
    true
    (apply = (vals (frequencies (filter #(re-find #"\p{L}" (str %)) (str/lower-case s)))))))


(defn isogram?
  [s]
  (if (empty? s)
    true
    (->> s
         str/lower-case
         (filter #(re-find #"\p{L}" (str %)))
         frequencies
         vals
         (apply =))))


(defn isogram?
  [s]
  (if (empty? s)
    true
    (->> s
         str/lower-case
         (filter #(Character/isLetter %))
         (apply distinct?))))


(defn isogram? [s]
  (not (re-matches #"(?i).*(\p{L}).*\1.*" s)))