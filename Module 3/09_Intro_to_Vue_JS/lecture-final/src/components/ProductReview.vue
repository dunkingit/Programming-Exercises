<template>
    <div class="main">
        <h2>Product Reviews for {{ name }}</h2>
        <p class="description"> {{ description }}</p>

        <div class="well-display">
            <div class="well">
                <span class="amount">{{ averageRating }}</span>
                Average Rating
            </div>

            <div class="well">
                <span class="amount">{{ numberOfOneStarReviews }}</span>
                1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfTwoStarReviews }}</span>
                2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfThreeStarReviews }}</span>
                3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfFourStarReviews }}</span>
                4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount">{{ numberOfFiveStarReviews }}</span>
                5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
            </div>
        </div>




        <div class="review" v-bind:class="{favorited : review.favorited}" v-for="review in reviews" v-bind:key="review.id" >
            <h4>{{ review.reviewer }}</h4>
            <div class="rating" v-if="review.favorited">

                <img src="../assets/star.png" alt="" v-for="numOfStars in review.rating" v-bind:key="numOfStars">
            </div>
            <h3>{{ review.title }}</h3>
            <p>{{ review.review }}</p>

            <p>
                Favorite?
                <input type="checkbox"  v-bind:id="'favorite_'+ review.id" v-model="review.favorited"/>
            </p>
            <div>
                <label for="test">Test</label>
                <input type="text" id="test" v-bind:id="'test_'+review.id" v-model="test">
            </div>
        </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            name: 'Vue for Dummies',
            description: 'Now with more ChatGPT!!',
            test: 'hello',
            testBoolean: true,
            reviews: [
                {
                    id: 1000,
                    reviewer: 'R Pérez',
                    title: 'Approachable pattern guide',
                    review:
                        'I love the uncomplicated, informal narrative style. I highly recommend this text for anyone trying to understand Design Patterns in a super simple way.',
                    rating: 4,
                    favorited: false,
                    test: 'hello',
                },
                {
                    id: 1001,
                    reviewer: 'Carmen',
                    title: 'Pattern complexity gone!',
                    review:
                        'I struggled for years to understand patterns and how to implement the design and how them. This is by far the best book to learn design patterns. I would give this 10 stars if I could.',
                    rating: 5,
                    favorited: false,
                    test: 'hello',
                },
                {
                    id: 1002,
                    reviewer: 'J. King',
                    title: 'Not for me',
                    review:
                        'The content is thorough and well described. However, the format just doesn\'t work for me. I need something more traditional.',
                    rating: 1,
                    favorited: false,
                    test: 'hello',
                },
                {
                    id: 1003,
                    reviewer: 'Safa H.',
                    title: 'Good for beginners',
                    review:
                        'Good introduction to design patterns especially if you have never used them before or are relatively new to OO principles.',
                    rating: 3,
                    favorited: true,
                    test: 'hello',
                },
                {
                    id: 1004,
                    reviewer: 'L Wang',
                    title: 'Entertaining',
                    review:
                        'If you are new to design patterns I HIGHLY recommend this book. You might think it\'s not "serious enough" at first. But as you go through it things just stick. It makes learning enjoyable.',
                    rating: 4,
                    favorited: false,
                    test: 'hello',
                }
            ]
        }
    },
    computed: {
        averageRating() {
            let sum = this.reviews.reduce((currentSum, review) => {
                return currentSum + review.rating;
            }, 0)
            return (sum / this.reviews.length).toFixed(0);
        },
        numberOfOneStarReviews() {
            const oneStarRatingReviews = this.reviews.filter((review) => {
                return review.rating === 1;
            })
            return oneStarRatingReviews.length;
        },
        numberOfTwoStarReviews() {
            const twoStarRatingReviews = this.reviews.filter((review) => {
                return review.rating === 2;
            })
            return twoStarRatingReviews.length;
        },
        numberOfThreeStarReviews() {
            const threeStarRatingReviews = this.reviews.filter((review) => {
                return review.rating === 3;
            })
            return threeStarRatingReviews.length;
        },
        numberOfFourStarReviews() {
            const fourStarRatingReviews = this.reviews.filter((review) => {
                return review.rating === 4;
            })
            return fourStarRatingReviews.length;
        },
        numberOfFiveStarReviews() {
            const fiveStarRatingReviews = this.reviews.filter((review) => {
                return review.rating === 5;
            })
            return fiveStarRatingReviews.length;
        }
    }
}
</script>

<style scoped>
.main {
    margin: 1rem 0;
}

.well-display {
    display: flex;
    justify-content: space-around;
    margin-bottom: 1rem;
}

.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
    padding: 0.25rem;
}

.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

.favorited {
    background-color: lightyellow;
}

.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

.rating img {
    height: 100%;
}

.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

.review p {
    margin: 20px;
}

.review h3 {
    display: inline-block;
}

.review h4 {
    font-size: 1rem;
}
</style>