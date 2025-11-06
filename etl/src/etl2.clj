(ns etl2
  (:require [clojure.string :as str]))

(def score->letters {1  [\a \e \i \o \u \l \n \r \s \t]
                     2  [\d \g]
                     3  [\b \c \m \p]
                     4  [\f \h \v \w \y]
                     5  [\k]
                     8  [\j \x]
                     10 [\q \z]})

(def letter->score (apply merge (map (fn [score]
                                       (let [letters (score->letters score)]
                                         (zipmap letters (repeat (count letters) score))))
                                     (keys score->letters))))


(defn transform
  [source]
  (into {} (for [[score letters] source letter letters]
             [(str/lower-case letter) score])))





;; {1 ["A"} -> {"a" 1}
;; {1 ["A" "E"], 2 ["D" "G"]} -> {"a" 1, "d" 2, "e" 1, "g" 2}



(val (first {1 ["A" "E"]}))


;; (map (fn [e] (into {} (map (fn [l] ([identity]))))))




(map (fn [e]
       (map (fn [l] [l (key e)]) (val e)))
     {1 ["A" "E"]})



(into {} (for [[score letters] {1 ["A" "E"] 2 ["D" "G"]} letter letters]
           [(str/lower-case letter) score]))
