(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[first-card] deck]
    first-card))


(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ second-card] deck]
    second-card))


;(defn swap-top-two-cards
;  "Returns the deck with first two items reversed."
;  [deck]
;  (let [[first-card second-card & remaining-cards] deck]
;    (concat [second-card] [first-card] remaining-cards)))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [[first second & rest]]
  (concat [second first] rest))


;(defn discard-top-card
;  "Returns a sequence containing the first card and
;   a sequence of the remaining cards in the deck."
;  [deck]
;  (let [[first-card & remaining-cards] deck]
;    (if (empty? remaining-cards)
;      [first-card nil]
;      [first-card (vec remaining-cards)])))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [[first & rest]]
  [first rest])


(def face-cards
  ["jack" "queen" "king"])

;(defn insert-face-cards
;  "Returns the deck with face cards between its head and tail."
;  [deck]
;  (let [[first-card & remaining-cards] deck]
;    (if (empty? deck)
;      face-cards
;      (concat [first-card] face-cards remaining-cards))))

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [[first & rest]]
  (if (nil? first)
    face-cards
    (concat [first] face-cards rest)))
