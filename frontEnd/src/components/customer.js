const Customer= (props)=> {
    const { customer }= props

    return (
        <div className="object">
          <div>{customer.name}</div>
          <div>{customer.birth_date}</div>
          <div>{customer.exact_Address}</div>
          <div>{customer.email}</div>
          <div>{customer.password}</div>
          <div>{customer.address}</div>
          <div>{customer.contact}</div>
          <div>{customer.answer}</div>
        </div>
    )   
}

export default Customer