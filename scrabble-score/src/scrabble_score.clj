(ns scrabble-score
  (:require [clojure.string :as str]))


(def score-groups
  {1  #{\A \E \I \O \U \L \N \R \S \T}
   2  #{\D \G}
   3  #{\B \C \M \P}
   4  #{\F \H \V \W \Y}
   5  #{\K}
   8  #{\J \X}
   10 #{\Q \Z}})

(def letter-scores
  (into {} (for [[score letters] score-groups
                 letter letters]
             [letter score])))

(defn score-word
  "Returns the scrabble score of a word."
  [word]
  (->> word
       str/upper-case
       (map letter-scores)
       (apply +)))
