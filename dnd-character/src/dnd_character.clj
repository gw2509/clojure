(ns dnd-character)


(defn score-modifier
  "Calculates the modifier of the given score."
  [score]
  (Math/floorDiv (- score 10) 2))


(defn rand-ability
  "Generates a random ability."
  []
  (reduce + (-> (repeatedly 4 #(inc (rand-int 6)))
                sort
                rest)))


(defn rand-character
  "Generates a random character."
  []
  (let [ability-scores (repeatedly 6 rand-ability)
        constitution (nth ability-scores 2)
        hit-points (+ 10 (score-modifier constitution))
        abilities (zipmap [:strength
                           :dexterity
                           :constitution
                           :intelligence
                           :wisdom
                           :charisma] ability-scores)]
    (assoc abilities :hitpoints hit-points)))