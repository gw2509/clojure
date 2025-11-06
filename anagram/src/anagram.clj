(ns anagram
  (:require [clojure.string :as str]))


(defn anagrams-for
  "Returns all words from candidates that are anagrams of the given word."
  [word candidates]
  (let [word (str/lower-case word)
        word-sorted (sort word)]
    (->> candidates
         (filter #(not= word (str/lower-case %)))
         (filter #(= word-sorted (sort (str/lower-case %)))))))


;; or..

(defn anagram?
  [word candidate]
  (and
    (not= word candidate)
    (= (sort word) (sort candidate))))

(defn anagrams-for
  [word candidates]
  (filter #(anagram? (str/lower-case word) (str/lower-case %))
          candidates))

