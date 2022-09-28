const styles= {
    container: {
        border: '1px solid lightskyblue',
        borderRadius: '10px',
        margin: '15px'
    },
    title: {
        color: 'black',
        textAlign: 'left',
        fontSize: '600',
        margin: '5px',
        padding: '5px'
    },
    vendor: {
        color: 'gray',
        textAlign: 'left',
        fontSize: '600',
        margin: '5px',
        padding: '5px'
    },
    review: {
        color: 'black',
        textAlign: 'left',
        fontSize: 'large',
        margin: '5px',
        padding: '5px'
    }
}

const Feedback= (props)=> {

    const { feedback }= props

    return (
        <div className="row">
            <div className="container" style= {styles.container}>
                <div className="title" style= {styles.title}>{feedback.title}</div>
                <div className="vendor" style= {styles.vendor}>on {feedback.vendor}</div>
                <div className="review" style= {styles.review}>{feedback.feedback_message}</div>
                
            </div>
        </div>
    )
}

export default Feedback