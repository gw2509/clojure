(ns acronym
  (:require [clojure.string :as str]))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (->> (str/split phrase #"[ -]")
       (remove str/blank?)
       (map #(re-find #"[A-Za-z]" (str %)))
       (map str/upper-case)
       (apply str)))


(defn acronym
  "Uses a regex pattern with lookbehind (?<=^|[-_ ]) to match letters [A-Za-z]
  that are preceded by a hyphen, underscore or space."
  [phrase]
  (->> (re-seq #"(?<=^|[-_ ])[A-Za-z]" phrase)
       (map first)
       (apply str)
       str/upper-case))


